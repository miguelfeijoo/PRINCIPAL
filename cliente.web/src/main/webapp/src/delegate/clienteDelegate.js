define(['delegate/_clienteDelegate'], function() {
    App.Delegate.ClienteDelegate = App.Delegate._ClienteDelegate.extend({
       
        comprarCarrito: function(id,callback,callbackError){
	    console.log('#Delegate#: comprar carrito : '+id);
            $.ajax({
	          url: '/carrito.service.subsystem/webresources/Carrito/'+id+'/comprarcarrito',
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