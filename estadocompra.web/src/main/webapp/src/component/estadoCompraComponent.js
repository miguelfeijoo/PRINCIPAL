define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/estadoCompraModel', 'controller/estadoCompraController'], function() {
    App.Component.EstadoCompraComponent = App.Component._CRUDComponent.extend({
        name: 'estadoCompra',
        model: App.Model.EstadoCompraModel,
        listModel: App.Model.EstadoCompraList,
        controller : App.Controller.EstadoCompraController
    });
    return App.Component.EstadoCompraComponent;
});