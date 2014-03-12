
package co.edu.uniandes.csw.componenteventasenlinea.logic.api;

import java.util.List; 

import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;

public interface _IComponenteVentasEnLineaLogicService {

	public ComponenteVentasEnLineaDTO createComponenteVentasEnLinea(ComponenteVentasEnLineaDTO detail);
	public List<ComponenteVentasEnLineaDTO> getComponenteVentasEnLineas();
	public ComponenteVentasEnLineaDTO getComponenteVentasEnLinea(Long id);
	public void deleteComponenteVentasEnLinea(Long id);
	public void updateComponenteVentasEnLinea(ComponenteVentasEnLineaDTO detail);
	
}