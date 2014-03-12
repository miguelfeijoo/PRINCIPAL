define(['component/_CRUDComponent', 'controller/toolbarController', 'model/toolbarModel', 'model/direccionModel', 'controller/direccionController'], function() {
    App.Component.DireccionComponent = App.Component._CRUDComponent.extend({
        name: 'direccion',
        model: App.Model.DireccionModel,
        listModel: App.Model.DireccionList,
        controller : App.Controller.DireccionController
    });
    return App.Component.DireccionComponent;
});