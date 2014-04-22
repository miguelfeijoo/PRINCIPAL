package co.edu.uniandes.csw.carrito.master.service;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/CarritoMaster")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarritoMasterService extends _CarritoMasterService
{

    @PUT
    @Path("/comprarCarrito")
    public boolean comprarCarrito()
    {
        System.out.println("!!!"); 
        
        return true;//return carritoLogicService.comprarCarrito(id);
    }

    @PUT
    @Path("{id}/finalizarCompra")
    public void finalizarCompra(@PathParam("id") Long id)
    {
        carritoLogicService.finalizarCompra(id);
    }
}
