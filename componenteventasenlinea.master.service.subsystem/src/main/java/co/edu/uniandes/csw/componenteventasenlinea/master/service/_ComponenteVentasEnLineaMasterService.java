package co.edu.uniandes.csw.componenteventasenlinea.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.componenteventasenlinea.master.logic.api.IComponenteVentasEnLineaMasterLogicService;
import co.edu.uniandes.csw.componenteventasenlinea.master.logic.dto.ComponenteVentasEnLineaMasterDTO;

public abstract class _ComponenteVentasEnLineaMasterService {

    @Inject
    protected IComponenteVentasEnLineaMasterLogicService componenteventasenlineaLogicService;

    @POST
    public ComponenteVentasEnLineaMasterDTO createComponenteVentasEnLinea(ComponenteVentasEnLineaMasterDTO componenteventasenlinea) {
        return componenteventasenlineaLogicService.createMasterComponenteVentasEnLinea(componenteventasenlinea);
    }

    @DELETE
    @Path("{id}")
    public void deleteComponenteVentasEnLinea(@PathParam("id") Long id) {
        componenteventasenlineaLogicService.deleteMasterComponenteVentasEnLinea(id);
    }
    
    @GET
    @Path("{id}")
    public ComponenteVentasEnLineaMasterDTO getComponenteVentasEnLinea(@PathParam("id") Long id) {
        return componenteventasenlineaLogicService.getMasterComponenteVentasEnLinea(id);
    }

    @PUT
    @Path("{id}")
    public void updateComponenteVentasEnLinea(@PathParam("id") Long id, ComponenteVentasEnLineaMasterDTO componenteventasenlinea) {
        componenteventasenlineaLogicService.updateMasterComponenteVentasEnLinea(componenteventasenlinea);
    }

}
