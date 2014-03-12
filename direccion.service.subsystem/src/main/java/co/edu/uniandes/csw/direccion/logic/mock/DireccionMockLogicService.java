
package co.edu.uniandes.csw.direccion.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.direccion.logic.api.IDireccionLogicService;

@Alternative
@Singleton
public class DireccionMockLogicService extends _DireccionMockLogicService implements IDireccionLogicService {
	
}