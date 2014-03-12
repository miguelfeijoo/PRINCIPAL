
package co.edu.uniandes.csw.cliente.logic.api;

import java.util.List; 

import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;

public interface _IClienteLogicService {

	public ClienteDTO createCliente(ClienteDTO detail);
	public List<ClienteDTO> getClientes();
	public ClienteDTO getCliente(Long id);
	public void deleteCliente(Long id);
	public void updateCliente(ClienteDTO detail);
	
}