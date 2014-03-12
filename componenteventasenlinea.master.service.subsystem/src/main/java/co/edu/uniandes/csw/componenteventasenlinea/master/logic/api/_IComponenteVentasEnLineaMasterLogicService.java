 
package co.edu.uniandes.csw.componenteventasenlinea.master.logic.api;

import co.edu.uniandes.csw.componenteventasenlinea.master.logic.dto.ComponenteVentasEnLineaMasterDTO;

public interface _IComponenteVentasEnLineaMasterLogicService {

	public ComponenteVentasEnLineaMasterDTO createMasterComponenteVentasEnLinea(ComponenteVentasEnLineaMasterDTO detail);
    public void updateMasterComponenteVentasEnLinea(ComponenteVentasEnLineaMasterDTO detail);
	public void deleteMasterComponenteVentasEnLinea(Long id); 
	public ComponenteVentasEnLineaMasterDTO getMasterComponenteVentasEnLinea(Long id);
        
}