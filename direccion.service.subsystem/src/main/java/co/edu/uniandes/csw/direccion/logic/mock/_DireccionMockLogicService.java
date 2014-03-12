
package co.edu.uniandes.csw.direccion.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;
import co.edu.uniandes.csw.direccion.logic.api._IDireccionLogicService;

public abstract class _DireccionMockLogicService implements _IDireccionLogicService {

	private Long id= new Long(1);
	protected List<DireccionDTO> data=new ArrayList<DireccionDTO>();

	public DireccionDTO createDireccion(DireccionDTO direccion){
		id++;
		direccion.setId(id);
		return direccion;
    }

	public List<DireccionDTO> getDireccions(){
		return data; 
	}

	public DireccionDTO getDireccion(Long id){
		for(DireccionDTO d:data){
			if(d.getId().equals(id)){
				return d;
			}
		}
		return null;
	}

	public void deleteDireccion(Long id){
	    DireccionDTO delete=null;
		for(DireccionDTO d:data){
			if(d.getId().equals(id)){
				delete=d;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateDireccion(DireccionDTO direccion){
	    DireccionDTO delete=null;
		for(DireccionDTO d:data){
			if(d.getId().equals(id)){
				delete=d;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(direccion);
		} 
	}	
}