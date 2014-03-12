package co.edu.uniandes.csw.componenteventasenlinea.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.api.IComponenteVentasEnLineaMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class ComponenteVentasEnLineaMasterPersistence extends _ComponenteVentasEnLineaMasterPersistence  implements IComponenteVentasEnLineaMasterPersistence {

}