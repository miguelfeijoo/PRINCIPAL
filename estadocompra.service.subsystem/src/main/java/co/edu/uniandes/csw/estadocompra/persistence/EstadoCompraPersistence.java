
package co.edu.uniandes.csw.estadocompra.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.estadocompra.persistence.api.IEstadoCompraPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class EstadoCompraPersistence extends _EstadoCompraPersistence  implements IEstadoCompraPersistence {

}