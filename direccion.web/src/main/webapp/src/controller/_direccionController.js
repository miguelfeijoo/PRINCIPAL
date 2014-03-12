define(['model/direccionModel'], function(direccionModel) {
    App.Controller._DireccionController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#direccion').html());
            this.listTemplate = _.template($('#direccionList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            Backbone.on(this.componentId + '-' + 'direccion-create', function(params) {
                self.create(params);
            });
            Backbone.on(this.componentId + '-' + 'direccion-list', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'direccion-edit', function(params) {
                self.edit(params);
            });
            Backbone.on(this.componentId + '-' + 'direccion-delete', function(params) {
                self.destroy(params);
            });
            Backbone.on(this.componentId + '-' + 'post-direccion-delete', function(params) {
                self.list(params);
            });
            Backbone.on(this.componentId + '-' + 'direccion-save', function(params) {
                self.save(params);
            });
            if(self.postInit){
            	self.postInit();
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-direccion-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-direccion-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-direccion-create', {view: this});
                this.currentDireccionModel = new this.modelClass();
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-direccion-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-direccion-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-direccion-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-direccion-list', {view: this, data: data});
                var self = this;
				if(!this.direccionModelList){
                 this.direccionModelList = new this.listModelClass();
				}
                this.direccionModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-direccion-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'direccion-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-direccion-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-direccion-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-direccion-edit', {view: this, id: id, data: data});
                if (this.direccionModelList) {
                    this.currentDireccionModel = this.direccionModelList.get(id);
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-direccion-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentDireccionModel = new this.modelClass({id: id});
                    this.currentDireccionModel.fetch({
                        data: data,
                        success: function() {
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-direccion-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'direccion-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-direccion-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-direccion-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-direccion-delete', {view: this, id: id});
                var deleteModel;
                if (this.direccionModelList) {
                    deleteModel = this.direccionModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-direccion-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'direccion-delete', view: self, error: error});
                    }
                });
            }
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-direccionForm').serializeObject();
            if (App.Utils.eventExists(this.componentId + '-' +'instead-direccion-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-direccion-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-direccion-save', {view: this, model : model});
                this.currentDireccionModel.set(model);
                this.currentDireccionModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-direccion-save', {model: self.currentDireccionModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'direccion-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({direccions: self.direccionModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({direccion: self.currentDireccionModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._DireccionController;
});