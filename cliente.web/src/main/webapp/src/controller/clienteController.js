define(['controller/_clienteController','delegate/clienteDelegate'], function() {
    App.Controller.ClienteController = App.Controller._ClienteController.extend({

        postInit: function (options)
        {                       
            var self = this;
            
            this.loginTemplate = _.template($('#registroUsuario').html());

            Backbone.on('login',function(params)
            {
                self.renderLogin(params);
            });
            
            Backbone.on('finalizarLogin',function(params)
            {
                self.login(params);
            });
        },
        
        login: function (params)
        {
            console.log('login ' + params.id);
            
            var self = this; 
            
            self.loginDelegate(params.usuario, params.contrasenia,function(data)
            {                
                Backbone.trigger('comprar-carrito', params.idCarrito);
                
            },function(data)
            {
                Backbone.trigger(self.componentId + '-' + 'error', {event: 'comprar-carrito', view: self, id: params.id, data: data, error: 'Error haciendo la compra'});
            });                        
        },
        
        loginDelegate: function(usuario, contrasenia, callback,callbackError)
        {
	    console.log('#delegate# login: '+ usuario);
            
            $.ajax({
                url: '/cliente.service.subsystem.web/webresources/Cliente/login',
                type: 'PUT',
                data: {usuario:usuario, contrasenia: contrasenia},  
                contentType: 'application/json'
            }).done(_.bind(function(data)
            {
                callback(data);
                     
            },this)).error(_.bind(function(data)
            {
                callbackError(data);
            },this));
        }, 
        
        _renderLogin: function(idCarrito) 
        {
            var self = this;
            this.$el.slideUp("fast", function()
            {
                self.$el.html(self.loginTemplate({componentId: self.componentId, idCarrito: idCarrito}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller.ClienteController;
}); 