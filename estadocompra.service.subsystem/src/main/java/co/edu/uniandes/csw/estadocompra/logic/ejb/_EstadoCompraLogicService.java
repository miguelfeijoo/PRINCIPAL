
package co.edu.uniandes.csw.estadocompra.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.estadocompra.logic.dto.EstadoCompraDTO;
import co.edu.uniandes.csw.estadocompra.logic.api._IEstadoCompraLogicService;
import co.edu.uniandes.csw.estadocompra.persistence.api.IEstadoCompraPersistence;

public abstract class _EstadoCompraLogicService implements _IEstadoCompraLogicService {

	@Inject
	protected IEstadoCompraPersistence persistance;

	public EstadoCompraDTO createEstadoCompra(EstadoCompraDTO estadoCompra){
		return persistance.createEstadoCompra( estadoCompra); 
    }

	public List<EstadoCompraDTO> getEstadoCompras(){
		return persistance.getEstadoCompras(); 
	}

	public EstadoCompraDTO getEstadoCompra(Long id){
		return persistance.getEstadoCompra(id); 
	}

	public void deleteEstadoCompra(Long id){
	    persistance.deleteEstadoCompra(id); 
	}

	public void updateEstadoCompra(EstadoCompraDTO estadoCompra){
	    persistance.updateEstadoCompra(estadoCompra); 
	}	
}