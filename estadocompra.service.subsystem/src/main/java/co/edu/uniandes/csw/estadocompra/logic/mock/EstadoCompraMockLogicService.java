
package co.edu.uniandes.csw.estadocompra.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.estadocompra.logic.api.IEstadoCompraLogicService;

@Alternative
@Singleton
public class EstadoCompraMockLogicService extends _EstadoCompraMockLogicService implements IEstadoCompraLogicService {
	
}