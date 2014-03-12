define([], function() {
    App.Model._DireccionModel = Backbone.Model.extend({
        defaults: {
 
		 'direccion' : ''
 ,  
		 'name' : ''
        },
        initialize: function() {
        },
        getDisplay: function(name) {
         return this.get(name);
        }
    });

    App.Model._DireccionList = Backbone.Collection.extend({
        model: App.Model._DireccionModel,
        initialize: function() {
        }

    });
    return App.Model._DireccionModel;
});