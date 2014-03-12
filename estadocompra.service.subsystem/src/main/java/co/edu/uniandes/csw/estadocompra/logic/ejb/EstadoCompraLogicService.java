
package co.edu.uniandes.csw.estadocompra.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.estadocompra.logic.api.IEstadoCompraLogicService;

@Default
@Stateless
@LocalBean
public class EstadoCompraLogicService extends _EstadoCompraLogicService implements IEstadoCompraLogicService {

}