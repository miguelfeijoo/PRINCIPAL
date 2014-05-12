package co.edu.uniandes.csw.cliente.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("/Cliente")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteService extends _ClienteService 
{
    @POST
    @Path("/login")
    public int login(String params)
    {      
        String usuario = params.split("&")[0].split("=")[1]; 
        String contrasenia = params.split("&")[1].split("=")[1];
         
        return clienteLogicService.login(usuario, contrasenia);
    }
}