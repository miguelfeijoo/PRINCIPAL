define(['controller/_clienteController','delegate/clienteDelegate'], function() {
    App.Controller.ClienteController = App.Controller._ClienteController.extend({

        postInit: function (options)
        {                       
            var self = this;
        },
    });
    return App.Controller.ClienteController;
}); 