
package co.edu.uniandes.csw.estadocompra.logic.api;

import java.util.List; 

import co.edu.uniandes.csw.estadocompra.logic.dto.EstadoCompraDTO;

public interface _IEstadoCompraLogicService {

	public EstadoCompraDTO createEstadoCompra(EstadoCompraDTO detail);
	public List<EstadoCompraDTO> getEstadoCompras();
	public EstadoCompraDTO getEstadoCompra(Long id);
	public void deleteEstadoCompra(Long id);
	public void updateEstadoCompra(EstadoCompraDTO detail);
	
}