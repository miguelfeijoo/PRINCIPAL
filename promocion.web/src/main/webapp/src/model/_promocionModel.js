define([], function() {
    App.Model._PromocionModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : ''
        },
        initialize: function() {
        },
        getDisplay: function(name) {
         return this.get(name);
        }
    });

    App.Model._PromocionList = Backbone.Collection.extend({
        model: App.Model._PromocionModel,
        initialize: function() {
        }

    });
    return App.Model._PromocionModel;
});