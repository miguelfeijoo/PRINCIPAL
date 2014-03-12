define(['model/estadoCompraModel'], function(estadoCompraModel) {
    App.Controller._EstadoCompraController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#estadoCompra').html());
            this.listTemplate = _.template($('#estadoCompraList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            Backbone.on(this.componentId + '-' + 'estadoCompra-create', function(params) {
                self.create(params);
            });
            Backbone.on(this.componentId + '-' + 'estadoCompra-list', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'estadoCompra-edit', function(params) {
                self.edit(params);
            });
            Backbone.on(this.componentId + '-' + 'estadoCompra-delete', function(params) {
                self.destroy(params);
            });
            Backbone.on(this.componentId + '-' + 'post-estadoCompra-delete', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'estadoCompra-save', function(params) {
                self.save(params);
            });
            if(self.postInit){
            	self.postInit();
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-estadoCompra-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-estadoCompra-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-estadoCompra-create', {view: this});
                this.currentEstadoCompraModel = new this.modelClass();
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-estadoCompra-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-estadoCompra-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-estadoCompra-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-estadoCompra-list', {view: this, data: data});
                var self = this;
				if(!this.estadoCompraModelList){
                 this.estadoCompraModelList = new this.listModelClass();
				}
                this.estadoCompraModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-estadoCompra-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'estadoCompra-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-estadoCompra-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-estadoCompra-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-estadoCompra-edit', {view: this, id: id, data: data});
                if (this.estadoCompraModelList) {
                    this.currentEstadoCompraModel = this.estadoCompraModelList.get(id);
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-estadoCompra-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentEstadoCompraModel = new this.modelClass({id: id});
                    this.currentEstadoCompraModel.fetch({
                        data: data,
                        success: function() {
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-estadoCompra-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'estadoCompra-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-estadoCompra-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-estadoCompra-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-estadoCompra-delete', {view: this, id: id});
                var deleteModel;
                if (this.estadoCompraModelList) {
                    deleteModel = this.estadoCompraModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-estadoCompra-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'estadoCompra-delete', view: self, error: error});
                    }
                });
            }
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-estadoCompraForm').serializeObject();
            if (App.Utils.eventExists(this.componentId + '-' +'instead-estadoCompra-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-estadoCompra-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-estadoCompra-save', {view: this, model : model});
                this.currentEstadoCompraModel.set(model);
                this.currentEstadoCompraModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-estadoCompra-save', {model: self.currentEstadoCompraModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'estadoCompra-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({estadoCompras: self.estadoCompraModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({estadoCompra: self.currentEstadoCompraModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._EstadoCompraController;
});