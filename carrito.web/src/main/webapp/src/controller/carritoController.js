define(['controller/_carritoController','delegate/carritoDelegate'], function() {
    App.Controller.CarritoController = App.Controller._CarritoController.extend({
            
        postInit: function (options)
        {
            var self = this;
            //this.selection = App.Controller.SelectionController ({});
            
            this.formaComprarCarritoTemplate = _.template($('#formaComprarCarrito').html());
            
            Backbone.on('comprar-carrito',function(params)
            {
                self.comprarCarrito(params);
            });
        },
        
        comprarCarrito: function (params)
        {
            console.log('comprar carrito' + params.id);
            
            var self = this; 
            
            /*App.Delegate.CarritoDelegate.comprarCarrito(params.id,function(data)
            {
                alert('Comprando carrito...');
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'comprar-carrito', view: self, id: params.id, data: data, error: 'Error haciendo la compra'});
            });*/
            
            this._renderFormaComprarCarrito();
        },
        
        _renderFormaComprarCarrito: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.formaComprarCarritoTemplate({carritos: self.carritoModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller.CarritoController;
}); 