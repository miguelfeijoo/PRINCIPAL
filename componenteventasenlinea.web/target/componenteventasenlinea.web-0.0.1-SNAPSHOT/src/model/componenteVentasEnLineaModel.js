define(['model/_componenteVentasEnLineaModel'], function() {
    App.Model.ComponenteVentasEnLineaModel = App.Model._ComponenteVentasEnLineaModel.extend({

    });

    App.Model.ComponenteVentasEnLineaList = App.Model._ComponenteVentasEnLineaList.extend({
        model: App.Model.ComponenteVentasEnLineaModel
    });

    return  App.Model.ComponenteVentasEnLineaModel;

});