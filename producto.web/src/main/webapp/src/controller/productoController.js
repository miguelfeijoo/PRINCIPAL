define(['controller/_productoController','delegate/productoDelegate'], function() {
    App.Controller.ProductoController = App.Controller._ProductoController.extend({
        
        postInit: function (options)
        {                        
            var self = this;
            
            //this.redirect = _.template($('#redirectCarrito').html());

            Backbone.on('agregar-producto-al-carrito',function(params)
            {
                self.agregarProductoAlCarrito(params);
            });
        }, 
         
        agregarProductoAlCarrito: function (params)
        {
            console.log('Agregar producto ' + params.id);
            
            var self = this; 
            
            self.agregarProductoAlCarritoDelegate(params.id,function(data)
            {
                //Se agrego el producto al carrito
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'agregar-al-carrito', view: self, id: params.id, data: data, error: 'Error agregando producto'});
            });            
        },
        
        agregarProductoAlCarritoDelegate: function(id,callback,callbackError)
        {
	    console.log('#delegate# agregar producto: '+id);
            
            $.ajax({
                url: '/carrito.master.service.subsystem/webresources/CarritoMaster/'+id+'/comprarCarrito',
                type: 'PUT',
                data: {},
                contentType: 'application/json'
            }).done(_.bind(function(data)
            {
                callback(data);
                     
            },this)).error(_.bind(function(data)
            {
                callbackError(data);
            },this));
        }, 
    });
    return App.Controller.ProductoController;
}); 