
package co.edu.uniandes.csw.direccion.logic.api;

import java.util.List; 

import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;

public interface _IDireccionLogicService {

	public DireccionDTO createDireccion(DireccionDTO detail);
	public List<DireccionDTO> getDireccions();
	public DireccionDTO getDireccion(Long id);
	public void deleteDireccion(Long id);
	public void updateDireccion(DireccionDTO detail);
	
}