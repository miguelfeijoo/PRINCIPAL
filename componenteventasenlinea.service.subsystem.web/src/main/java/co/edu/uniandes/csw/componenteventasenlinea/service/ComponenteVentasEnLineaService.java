package co.edu.uniandes.csw.componenteventasenlinea.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ComponenteVentasEnLinea")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComponenteVentasEnLineaService extends _ComponenteVentasEnLineaService {


}