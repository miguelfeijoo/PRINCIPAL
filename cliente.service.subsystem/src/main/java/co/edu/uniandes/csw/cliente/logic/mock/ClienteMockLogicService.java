
package co.edu.uniandes.csw.cliente.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.cliente.logic.api.IClienteLogicService;

@Alternative
@Singleton
public class ClienteMockLogicService extends _ClienteMockLogicService implements IClienteLogicService 
{

    public int login(String usuario, String contrasenia) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}