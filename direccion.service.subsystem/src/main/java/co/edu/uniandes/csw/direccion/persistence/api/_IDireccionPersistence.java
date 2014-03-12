
package co.edu.uniandes.csw.direccion.persistence.api;

import java.util.List; 

import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;

public interface _IDireccionPersistence {

	public DireccionDTO createDireccion(DireccionDTO detail);
	public List<DireccionDTO> getDireccions();
	public DireccionDTO getDireccion(Long id);
	public void deleteDireccion(Long id);
	public void updateDireccion(DireccionDTO detail);
	
}