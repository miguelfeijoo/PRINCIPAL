package co.edu.uniandes.csw.factura.service;

import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Factura")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FacturaService extends _FacturaService 
{
    @GET
    @Path("/darFacturas")
    
    public List<FacturaDTO> darFacturas ()
    {
        return facturaLogicService.getFacturas();
    }
    
    
}