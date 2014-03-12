define([], function() {
    App.Model._ComponenteVentasEnLineaModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : ''
 ,  
		 'productoId' : ''
        },
        initialize: function() {
        },
        getDisplay: function(name) {
			 if(name=='productoId'){  
                 var value = App.Utils.getModelFromCache('productoComponent',this.get('productoId'));
                 if(value) 
                 return value.get('name');
             }
         return this.get(name);
        }
    });

    App.Model._ComponenteVentasEnLineaList = Backbone.Collection.extend({
        model: App.Model._ComponenteVentasEnLineaModel,
        initialize: function() {
        }

    });
    return App.Model._ComponenteVentasEnLineaModel;
});