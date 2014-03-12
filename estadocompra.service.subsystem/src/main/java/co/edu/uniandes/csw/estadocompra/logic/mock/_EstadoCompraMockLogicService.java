
package co.edu.uniandes.csw.estadocompra.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.estadocompra.logic.dto.EstadoCompraDTO;
import co.edu.uniandes.csw.estadocompra.logic.api._IEstadoCompraLogicService;

public abstract class _EstadoCompraMockLogicService implements _IEstadoCompraLogicService {

	private Long id= new Long(1);
	protected List<EstadoCompraDTO> data=new ArrayList<EstadoCompraDTO>();

	public EstadoCompraDTO createEstadoCompra(EstadoCompraDTO estadoCompra){
		id++;
		estadoCompra.setId(id);
		return estadoCompra;
    }

	public List<EstadoCompraDTO> getEstadoCompras(){
		return data; 
	}

	public EstadoCompraDTO getEstadoCompra(Long id){
		for(EstadoCompraDTO d:data){
			if(d.getId().equals(id)){
				return d;
			}
		}
		return null;
	}

	public void deleteEstadoCompra(Long id){
	    EstadoCompraDTO delete=null;
		for(EstadoCompraDTO d:data){
			if(d.getId().equals(id)){
				delete=d;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateEstadoCompra(EstadoCompraDTO estadoCompra){
	    EstadoCompraDTO delete=null;
		for(EstadoCompraDTO d:data){
			if(d.getId().equals(id)){
				delete=d;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(estadoCompra);
		} 
	}	
}