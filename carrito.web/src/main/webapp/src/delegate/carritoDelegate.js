define(['delegate/_carritoDelegate'], function() {
    App.Delegate.CarritoDelegate = App.Delegate._CarritoDelegate.extend({
        
        comprarCarrito: function(id,callback,callbackError)
        {
	    console.log('#delegate# comprarcarrito: '+id);
            $.ajax({
	          url: '/carrito.master.service.subsystem/webresources/CarritoMaster/'+id+'/comprarcarrito',
	          type: 'PUT',
	          data: {},
	          contentType: 'application/json'
	      }).done(_.bind(function(data){
	    	  callback(data);
	      },this)).error(_.bind(function(data){
	    	  callbackError(data);
	      },this));
        }
    });
});