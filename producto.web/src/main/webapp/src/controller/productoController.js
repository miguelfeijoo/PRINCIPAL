define(['controller/_productoController','delegate/productoDelegate'], function() {
    App.Controller.ProductoController = App.Controller._ProductoController.extend({
        
        postInit: function (options)
        {                        
            var self = this;
            
            this.nuevoItem = _.template($('#nuevoItem').html());
            this.productoAgregado = _.template($('#productoAgregado').html());

            Backbone.on('agregar-producto-al-carrito',function(params)
            {
                self.agregarProductoAlCarrito(params);
            });
            
            Backbone.on('finalizar-agregar-producto-al-carrito',function(params)
            {
                self.finalizarAgregarProductoAlCarrito($('#numUnidades').val(), params);
            });
        }, 
        
        agregarProductoAlCarrito: function (params)
        {
            console.log('Agregar producto ' + params.id);
            
            this._renderNuevoItem(params.id,null);         
        },
         
        finalizarAgregarProductoAlCarrito: function (numeroUnidades, params)
        {
            console.log('Agregar producto ' + params.id);
            
            var self = this; 
            
            self.agregarProductoAlCarritoDelegate(params.idProducto, numeroUnidades,function(data)
            {
                //Se agrego el producto al carrito
                
                self._renderAgregado();
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'agregar-al-carrito', view: self, id: params.id, data: data, error: 'Error agregando producto'});
            });            
        },
        
        agregarProductoAlCarritoDelegate: function(idProducto, numeroUnidades,callback,callbackError)
        {
	    console.log('#delegate# agregar producto: '+idProducto);
            
            $.ajax({
                url: '/itemfactura.service.subsystem.web/webresources/ItemFactura/'+idProducto+'/'+numeroUnidades+'/agregarAlCarrito',
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
        
        _renderNuevoItem: function(idProducto, nombreProducto) 
        {
            var self = this;
            this.$el.slideUp("fast", function() 
            {
                self.$el.html(self.nuevoItem({componentId: self.componentId, idProducto: idProducto, nombreProducto: 'nada'}));
                self.$el.slideDown("fast");
            });
        },
        _renderAgregado: function() 
        {
            var self = this;
            this.$el.slideUp("fast", function() 
            {
                self.$el.html(self.productoAgregado({componentId: self.componentId}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller.ProductoController;
}); 