
package co.edu.uniandes.csw.cliente.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.cliente.logic.api.IClienteLogicService;
import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import java.util.List;

@Default
@Stateless
@LocalBean
public class ClienteLogicService extends _ClienteLogicService implements IClienteLogicService
{
    public int login(String usuario, String contrasenia) 
    {
        List<ClienteDTO> clientes = persistance.getClientes();
        ClienteDTO cliente = null;
        boolean contraseniaCorrecta = false;
        
        for (ClienteDTO clienteDTO : clientes) 
        {
            if (clienteDTO.getNombre().equals(usuario))
            {
                cliente = clienteDTO;
                break;
            }
        }
        
        if (cliente != null)
        {
            if (cliente.getContrasenia().equals(contrasenia))
            {
                contraseniaCorrecta = true;
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            //Crear un nuevo usuario 
            cliente = new ClienteDTO();
            cliente.setName(usuario);
            cliente.setContrasenia(contrasenia); 
  
            persistance.createCliente(cliente);
            
            return 2;
        }    
    }

}