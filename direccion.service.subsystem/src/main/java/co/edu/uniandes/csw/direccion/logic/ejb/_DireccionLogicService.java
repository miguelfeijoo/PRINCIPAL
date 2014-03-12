
package co.edu.uniandes.csw.direccion.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;
import co.edu.uniandes.csw.direccion.logic.api._IDireccionLogicService;
import co.edu.uniandes.csw.direccion.persistence.api.IDireccionPersistence;

public abstract class _DireccionLogicService implements _IDireccionLogicService {

	@Inject
	protected IDireccionPersistence persistance;

	public DireccionDTO createDireccion(DireccionDTO direccion){
		return persistance.createDireccion( direccion); 
    }

	public List<DireccionDTO> getDireccions(){
		return persistance.getDireccions(); 
	}

	public DireccionDTO getDireccion(Long id){
		return persistance.getDireccion(id); 
	}

	public void deleteDireccion(Long id){
	    persistance.deleteDireccion(id); 
	}

	public void updateDireccion(DireccionDTO direccion){
	    persistance.updateDireccion(direccion); 
	}	
}