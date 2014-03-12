define(['model/componenteVentasEnLineaModel'], function(componenteVentasEnLineaModel) {
    App.Controller._ComponenteVentasEnLineaController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#componenteVentasEnLinea').html());
            this.listTemplate = _.template($('#componenteVentasEnLineaList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            Backbone.on(this.componentId + '-' + 'componenteVentasEnLinea-create', function(params) {
                self.create(params);
            });
            Backbone.on(this.componentId + '-' + 'componenteVentasEnLinea-list', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'componenteVentasEnLinea-edit', function(params) {
                self.edit(params);
            });
            Backbone.on(this.componentId + '-' + 'componenteVentasEnLinea-delete', function(params) {
                self.destroy(params);
            });
            Backbone.on(this.componentId + '-' + 'post-componenteVentasEnLinea-delete', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'componenteVentasEnLinea-save', function(params) {
                self.save(params);
            });
            if(self.postInit){
            	self.postInit();
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-componenteVentasEnLinea-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-componenteVentasEnLinea-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-componenteVentasEnLinea-create', {view: this});
                this.currentComponenteVentasEnLineaModel = new this.modelClass();
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-componenteVentasEnLinea-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-componenteVentasEnLinea-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-componenteVentasEnLinea-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-componenteVentasEnLinea-list', {view: this, data: data});
                var self = this;
				if(!this.componenteVentasEnLineaModelList){
                 this.componenteVentasEnLineaModelList = new this.listModelClass();
				}
                this.componenteVentasEnLineaModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-componenteVentasEnLinea-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'componenteVentasEnLinea-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-componenteVentasEnLinea-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-componenteVentasEnLinea-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-componenteVentasEnLinea-edit', {view: this, id: id, data: data});
                if (this.componenteVentasEnLineaModelList) {
                    this.currentComponenteVentasEnLineaModel = this.componenteVentasEnLineaModelList.get(id);
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-componenteVentasEnLinea-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentComponenteVentasEnLineaModel = new this.modelClass({id: id});
                    this.currentComponenteVentasEnLineaModel.fetch({
                        data: data,
                        success: function() {
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-componenteVentasEnLinea-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'componenteVentasEnLinea-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-componenteVentasEnLinea-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-componenteVentasEnLinea-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-componenteVentasEnLinea-delete', {view: this, id: id});
                var deleteModel;
                if (this.componenteVentasEnLineaModelList) {
                    deleteModel = this.componenteVentasEnLineaModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-componenteVentasEnLinea-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'componenteVentasEnLinea-delete', view: self, error: error});
                    }
                });
            }
        },
		_loadRequiredComponentsData: function(callBack) {
            var self = this;
            var listReady = _.after(1, function(){
                callBack();
            }); 
            var listDataReady = function(componentName, model){
                self[componentName] = model;
                listReady();
            };
				App.Utils.getComponentList('productoComponent',listDataReady);
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-componenteVentasEnLineaForm').serializeObject();
            if (App.Utils.eventExists(this.componentId + '-' +'instead-componenteVentasEnLinea-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-componenteVentasEnLinea-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-componenteVentasEnLinea-save', {view: this, model : model});
                this.currentComponenteVentasEnLineaModel.set(model);
                this.currentComponenteVentasEnLineaModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-componenteVentasEnLinea-save', {model: self.currentComponenteVentasEnLineaModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'componenteVentasEnLinea-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({componenteVentasEnLineas: self.componenteVentasEnLineaModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({componenteVentasEnLinea: self.currentComponenteVentasEnLineaModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				    ,producto: self.productoComponent
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._ComponenteVentasEnLineaController;
});