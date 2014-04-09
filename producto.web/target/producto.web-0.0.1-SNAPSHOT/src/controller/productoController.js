define(['controller/_productoController','delegate/productoDelegate'], function() {
    App.Controller.ProductoController = App.Controller._ProductoController.extend({
        
        postInit: function (options)
        {                        
            var self = this;
            
            this.redirect = _.template($('#redirectCarrito').html());

            Backbone.on('agregar-producto-al-carrito',function(params)
            {
                self.agregarProductoAlCarrito(params);
            });
        },
        
        agregarProductoAlCarrito: function (params)
        {
            console.log('Agregar producto ' + params.id);
            
            var self = this; 
            
            App.Delegate.CarritoDelegate.comprarCarrito(params.id,function(data)
            {
                //Se agrego el producto al carrito
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'agregar-al-carrito', view: self, id: params.id, data: data, error: 'Error agregando producto'});
            });            
        },
    });
    return App.Controller.ProductoController;
}); 