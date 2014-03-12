define(['model/_direccionModel'], function() {
    App.Model.DireccionModel = App.Model._DireccionModel.extend({

    });

    App.Model.DireccionList = App.Model._DireccionList.extend({
        model: App.Model.DireccionModel
    });

    return  App.Model.DireccionModel;

});