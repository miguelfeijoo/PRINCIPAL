
package co.edu.uniandes.csw.direccion.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.direccion.persistence.api.IDireccionPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class DireccionPersistence extends _DireccionPersistence  implements IDireccionPersistence {

}