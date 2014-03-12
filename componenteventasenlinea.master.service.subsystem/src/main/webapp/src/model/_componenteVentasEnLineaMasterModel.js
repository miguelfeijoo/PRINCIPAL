define([], function() {
    App.Model._ComponenteVentasEnLineaMasterModel = Backbone.Model.extend({
     
    });

    App.Model._ComponenteVentasEnLineaMasterList = Backbone.Collection.extend({
        model: App.Model._ComponenteVentasEnLineaMasterModel,
        initialize: function() {
        }

    });
    return App.Model._ComponenteVentasEnLineaMasterModel;
    
});