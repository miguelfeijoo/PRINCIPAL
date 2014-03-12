
package co.edu.uniandes.csw.componenteventasenlinea.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.componenteventasenlinea.logic.api.IComponenteVentasEnLineaLogicService;

@Default
@Stateless
@LocalBean
public class ComponenteVentasEnLineaLogicService extends _ComponenteVentasEnLineaLogicService implements IComponenteVentasEnLineaLogicService {

}