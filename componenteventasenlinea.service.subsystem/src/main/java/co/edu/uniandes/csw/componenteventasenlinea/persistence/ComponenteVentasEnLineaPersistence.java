
package co.edu.uniandes.csw.componenteventasenlinea.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.componenteventasenlinea.persistence.api.IComponenteVentasEnLineaPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class ComponenteVentasEnLineaPersistence extends _ComponenteVentasEnLineaPersistence  implements IComponenteVentasEnLineaPersistence {

}