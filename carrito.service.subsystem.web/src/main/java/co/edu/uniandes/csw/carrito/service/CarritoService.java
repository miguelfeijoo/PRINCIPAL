package co.edu.uniandes.csw.carrito.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PUT;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;


@Path("/Carrito")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarritoService extends _CarritoService 
{
    @PUT
    @Path("{id}/comprarcarrito")
    public void comprarCarrito(@PathParam("id") Long id) 
    {
        carritoLogicService.comprarCarrito(id);
    }

}