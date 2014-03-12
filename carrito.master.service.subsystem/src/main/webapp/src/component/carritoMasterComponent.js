define(['controller/selectionController', 'model/cacheModel', 'model/carritoMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/carritoComponent',
 'component/itemComponent'
 
 ],function(SelectionController, CacheModel, CarritoMasterModel, CRUDComponent, TabController, CarritoComponent,
 ItemComponent
 ) {
    App.Component.CarritoMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('carritoMaster');
            var uComponent = new CarritoComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-carrito-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-carrito-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-carrito-list', function() {
                self.hideChilds();
            });
            Backbone.on('carrito-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'carrito-master-save', view: self, error: error});
            });
            Backbone.on(uComponent.componentId + '-instead-carrito-save', function(params) {
                self.model.set('carritoEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var itemModels = self.itemComponent.componentController.itemModelList;
                self.model.set('listItem', []);
                self.model.set('createItem', []);
                self.model.set('updateItem', []);
                self.model.set('deleteItem', []);
                for (var i = 0; i < itemModels.models.length; i++) {
                    var m = itemModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createItem').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateItem').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < itemModels.deletedModels.length; i++) {
                    var m = itemModels.deletedModels[i];
                    self.model.get('deleteItem').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        uComponent.componentController.list();
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'carrito-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Item", name: "item", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.CarritoMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.itemComponent = new ItemComponent();
                    self.itemModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ItemModel), self.model.get('listItem'));
                    self.itemComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ItemModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ItemModel, App.Model.ItemList, self.itemModels)
                    });
                    self.itemComponent.render(self.tabs.getTabHtmlId('item'));
                    Backbone.on(self.itemComponent.componentId + '-post-item-create', function(params) {
                        params.view.currentItemModel.setCacheList(params.view.itemModelList);
                    });
                    self.itemToolbarModel = self.itemComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.itemComponent.setToolbarModel(self.itemToolbarModel);                    
                	
                     
                
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'carrito-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.CarritoMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.CarritoMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.CarritoMasterComponent;
});