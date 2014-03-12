package co.edu.uniandes.csw.componenteventasenlinea.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.componenteventasenlinea.logic.api.IComponenteVentasEnLineaLogicService;
import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;


public abstract class _ComponenteVentasEnLineaService {

	@Inject
	protected IComponenteVentasEnLineaLogicService componenteVentasEnLineaLogicService;
	
	@POST
	public ComponenteVentasEnLineaDTO createComponenteVentasEnLinea(ComponenteVentasEnLineaDTO componenteVentasEnLinea){
		return componenteVentasEnLineaLogicService.createComponenteVentasEnLinea(componenteVentasEnLinea);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteComponenteVentasEnLinea(@PathParam("id") Long id){
		componenteVentasEnLineaLogicService.deleteComponenteVentasEnLinea(id);
	}
	
	@GET
	public List<ComponenteVentasEnLineaDTO> getComponenteVentasEnLineas(){
		return componenteVentasEnLineaLogicService.getComponenteVentasEnLineas();
	}
	
	@GET
	@Path("{id}")
	public ComponenteVentasEnLineaDTO getComponenteVentasEnLinea(@PathParam("id") Long id){
		return componenteVentasEnLineaLogicService.getComponenteVentasEnLinea(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateComponenteVentasEnLinea(@PathParam("id") Long id, ComponenteVentasEnLineaDTO componenteVentasEnLinea){
		componenteVentasEnLineaLogicService.updateComponenteVentasEnLinea(componenteVentasEnLinea);
	}
	
}