define([], function() {
    App.Model._EstadoCompraModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : ''
        },
        initialize: function() {
        },
        getDisplay: function(name) {
         return this.get(name);
        }
    });

    App.Model._EstadoCompraList = Backbone.Collection.extend({
        model: App.Model._EstadoCompraModel,
        initialize: function() {
        }

    });
    return App.Model._EstadoCompraModel;
});