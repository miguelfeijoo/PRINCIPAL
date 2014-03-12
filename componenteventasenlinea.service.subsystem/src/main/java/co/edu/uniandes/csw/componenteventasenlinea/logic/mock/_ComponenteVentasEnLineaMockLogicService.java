
package co.edu.uniandes.csw.componenteventasenlinea.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.logic.api._IComponenteVentasEnLineaLogicService;

public abstract class _ComponenteVentasEnLineaMockLogicService implements _IComponenteVentasEnLineaLogicService {

	private Long id= new Long(1);
	protected List<ComponenteVentasEnLineaDTO> data=new ArrayList<ComponenteVentasEnLineaDTO>();

	public ComponenteVentasEnLineaDTO createComponenteVentasEnLinea(ComponenteVentasEnLineaDTO componenteVentasEnLinea){
		id++;
		componenteVentasEnLinea.setId(id);
		return componenteVentasEnLinea;
    }

	public List<ComponenteVentasEnLineaDTO> getComponenteVentasEnLineas(){
		return data; 
	}

	public ComponenteVentasEnLineaDTO getComponenteVentasEnLinea(Long id){
		for(ComponenteVentasEnLineaDTO d:data){
			if(d.getId().equals(id)){
				return d;
			}
		}
		return null;
	}

	public void deleteComponenteVentasEnLinea(Long id){
	    ComponenteVentasEnLineaDTO delete=null;
		for(ComponenteVentasEnLineaDTO d:data){
			if(d.getId().equals(id)){
				delete=d;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateComponenteVentasEnLinea(ComponenteVentasEnLineaDTO componenteVentasEnLinea){
	    ComponenteVentasEnLineaDTO delete=null;
		for(ComponenteVentasEnLineaDTO d:data){
			if(d.getId().equals(id)){
				delete=d;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(componenteVentasEnLinea);
		} 
	}	
}