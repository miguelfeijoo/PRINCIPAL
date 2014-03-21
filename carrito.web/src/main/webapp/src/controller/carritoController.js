define(['controller/_carritoController','delegate/carritoDelegate'], function() {
    App.Controller.CarritoController = App.Controller._CarritoController.extend({
            
        postInit: function (options)
        {
            var self = this;
            //this.selection = App.Controller.SelectionController ({});
            
            Backbone.on('comprar-carrito',function(params)
            {
                self.comprarCarrito(params);
            });
        },
        
        comprarCarrito: function (params)
        {
            console.log('comprar carrito' + params.id);
            
            var self = this;
            
            App.Delegate.CarritoDelegate.comprarCarrito(params.id,function(data)
            {
                alert('Comprando carrito...');
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'comprar-carrito', view: self, id: params.id, data: data, error: 'Error haciendo la compra'});
            });
        }
    });
    return App.Controller.CarritoController;
}); 