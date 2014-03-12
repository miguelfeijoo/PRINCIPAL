define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/componenteVentasEnLineaModel', 'controller/componenteVentasEnLineaController'], function() {
    App.Component.ComponenteVentasEnLineaComponent = App.Component._CRUDComponent.extend({
        name: 'componenteVentasEnLinea',
        model: App.Model.ComponenteVentasEnLineaModel,
        listModel: App.Model.ComponenteVentasEnLineaList,
        controller : App.Controller.ComponenteVentasEnLineaController
    });
    return App.Component.ComponenteVentasEnLineaComponent;
});