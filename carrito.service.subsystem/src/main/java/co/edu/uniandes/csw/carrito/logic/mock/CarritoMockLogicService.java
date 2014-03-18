
package co.edu.uniandes.csw.carrito.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.carrito.logic.api.ICarritoLogicService;

@Alternative
@Singleton
public class CarritoMockLogicService extends _CarritoMockLogicService implements ICarritoLogicService {

    public void comprarCarrito(Long id) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}