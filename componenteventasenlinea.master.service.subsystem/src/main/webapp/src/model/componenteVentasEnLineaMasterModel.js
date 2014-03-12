define(['model/_componenteVentasEnLineaMasterModel'], function() { 
    App.Model.ComponenteVentasEnLineaMasterModel = App.Model._ComponenteVentasEnLineaMasterModel.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('componenteVentasEnLinea-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.ComponenteVentasEnLineaModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.componenteVentasEnLineaEntity,options);
            }
        }
    });

    App.Model.ComponenteVentasEnLineaMasterList = App.Model._ComponenteVentasEnLineaMasterList.extend({
        model: App.Model.ComponenteVentasEnLineaMasterModel
    });

    return  App.Model.ComponenteVentasEnLineaMasterModel;

});