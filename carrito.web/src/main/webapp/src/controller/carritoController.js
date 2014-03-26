define(['controller/_carritoController','delegate/carritoDelegate'], function() {
    App.Controller.CarritoController = App.Controller._CarritoController.extend({
            
        postInit: function (options)
        {
            var self = this;
            //this.selection = App.Controller.SelectionController ({});
            
            this.formaComprarCarritoTemplate = _.template($('#formaComprarCarrito').html());
            this.compraFinalizadaTemplate = _.template($('#compraFinalizada').html());
            this.cancelarCompraCarrito = _.template($('#cancelarCompraCarrito').html());

            
            Backbone.on('comprar-carrito',function(params)
            {
                self.comprarCarrito(params);
            });
            
            Backbone.on('finalizar-compra-carrito',function(params)
            {
                self.finalizarCompraCarrito(params);
            });
            
            Backbone.on('cancelar-compra-carrito',function(params)
            {
                self.cancelarCompraCarrito(params);
            });
            
        },
        
        comprarCarrito: function (params)
        {
            console.log('Comprar carrito ' + params.id);
            
            var self = this; 
            
            /*App.Delegate.CarritoDelegate.comprarCarrito(params.id,function(data)
            {
                self._renderFormaComprarCarrito(params.id);
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'comprar-carrito', view: self, id: params.id, data: data, error: 'Error haciendo la compra'});
            });   */
            
            this._renderFormaComprarCarrito(params.id); //<<--PARA PRUEBAS por lo que lo de arriba no está sirviendo
        },
        cancelarCompraCarrito: function (params)
        {
            console.log('Comprar carrito ' + params.id);
            
            var self = this; 
            
            /*App.Delegate.CarritoDelegate.comprarCarrito(params.id,function(data)
            {
                self._renderFormaComprarCarrito(params.id);
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'comprar-carrito', view: self, id: params.id, data: data, error: 'Error haciendo la compra'});
            });   */
            
            this._renderCancelarCompraCarrito(params.id); //<<--PARA PRUEBAS por lo que lo de arriba no está sirviendo
        },
        
        finalizarCompraCarrito: function (params)
        {
            console.log('Finalizar compra carrito ' + params.id);
            
            var self = this; 
            
            /*App.Delegate.CarritoDelegate.finalizarCompra(params.id,function(data)
            {
                self._renderCompraFinalizada(params.id);
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'comprar-carrito', view: self, id: params.id, data: data, error: 'Error haciendo la compra'});
            });*/ 
            
            this._renderCompraFinalizada(params.id); //PARA PRUEBAS
        },
        
        _renderFormaComprarCarrito: function(id) {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.formaComprarCarritoTemplate({componentId: self.componentId, idCarrito: id}));
                self.$el.slideDown("fast");
            });
        },
         _renderCancelarCompraCarrito: function(id) {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.cancelarCompraCarrito({componentId: self.componentId, idCarrito: id}));
                self.$el.slideDown("fast");
            });
        },
        
        _renderCompraFinalizada: function(id) {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.compraFinalizadaTemplate({componentId: self.componentId, idCarrito: id}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller.CarritoController;
}); 