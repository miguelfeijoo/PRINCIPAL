define(['model/_estadoCompraModel'], function() {
    App.Model.EstadoCompraModel = App.Model._EstadoCompraModel.extend({

    });

    App.Model.EstadoCompraList = App.Model._EstadoCompraList.extend({
        model: App.Model.EstadoCompraModel
    });

    return  App.Model.EstadoCompraModel;

});