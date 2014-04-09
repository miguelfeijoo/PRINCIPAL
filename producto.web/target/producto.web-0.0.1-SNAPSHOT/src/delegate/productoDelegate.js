define(['delegate/_productoDelegate'], function() {
    App.Delegate.ProductoDelegate = App.Delegate._ProductoDelegate.extend({
        
        agregarProductoAlCarrito: function(id,callback,callbackError)
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
});