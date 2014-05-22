define([], function() {
    App.Model._ItemModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : ''
 ,  
		 'cantidad' : ''
 ,  
		 'productId' : ''
        },
        initialize: function() {
        },
        getDisplay: function(name) {
			 if(name=='productId'){  
                 var value = App.Utils.getModelFromCache('productComponent',this.get('productId'));
                 if(value) 
                 return value.get('name');
             }
         return this.get(name);
        }
    });

    App.Model._ItemList = Backbone.Collection.extend({
        model: App.Model._ItemModel,
        initialize: function() {
        }

    });
    return App.Model._ItemModel;
});