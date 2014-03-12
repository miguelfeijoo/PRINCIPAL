
package co.edu.uniandes.csw.direccion.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.direccion.logic.api.IDireccionLogicService;

@Default
@Stateless
@LocalBean
public class DireccionLogicService extends _DireccionLogicService implements IDireccionLogicService {

}