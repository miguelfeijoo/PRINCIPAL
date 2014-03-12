
package co.edu.uniandes.csw.componenteventasenlinea.logic.mock;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import co.edu.uniandes.csw.componenteventasenlinea.logic.api.IComponenteVentasEnLineaLogicService;

@Alternative
@Singleton
public class ComponenteVentasEnLineaMockLogicService extends _ComponenteVentasEnLineaMockLogicService implements IComponenteVentasEnLineaLogicService {
	
}