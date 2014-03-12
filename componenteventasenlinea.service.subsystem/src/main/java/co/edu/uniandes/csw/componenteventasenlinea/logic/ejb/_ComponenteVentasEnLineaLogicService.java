
package co.edu.uniandes.csw.componenteventasenlinea.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.logic.api._IComponenteVentasEnLineaLogicService;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.api.IComponenteVentasEnLineaPersistence;

public abstract class _ComponenteVentasEnLineaLogicService implements _IComponenteVentasEnLineaLogicService {

	@Inject
	protected IComponenteVentasEnLineaPersistence persistance;

	public ComponenteVentasEnLineaDTO createComponenteVentasEnLinea(ComponenteVentasEnLineaDTO componenteVentasEnLinea){
		return persistance.createComponenteVentasEnLinea( componenteVentasEnLinea); 
    }

	public List<ComponenteVentasEnLineaDTO> getComponenteVentasEnLineas(){
		return persistance.getComponenteVentasEnLineas(); 
	}

	public ComponenteVentasEnLineaDTO getComponenteVentasEnLinea(Long id){
		return persistance.getComponenteVentasEnLinea(id); 
	}

	public void deleteComponenteVentasEnLinea(Long id){
	    persistance.deleteComponenteVentasEnLinea(id); 
	}

	public void updateComponenteVentasEnLinea(ComponenteVentasEnLineaDTO componenteVentasEnLinea){
	    persistance.updateComponenteVentasEnLinea(componenteVentasEnLinea); 
	}	
}