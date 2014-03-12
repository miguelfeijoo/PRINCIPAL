package co.edu.uniandes.csw.estadocompra.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.estadocompra.logic.api.IEstadoCompraLogicService;
import co.edu.uniandes.csw.estadocompra.logic.dto.EstadoCompraDTO;


public abstract class _EstadoCompraService {

	@Inject
	protected IEstadoCompraLogicService estadoCompraLogicService;
	
	@POST
	public EstadoCompraDTO createEstadoCompra(EstadoCompraDTO estadoCompra){
		return estadoCompraLogicService.createEstadoCompra(estadoCompra);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteEstadoCompra(@PathParam("id") Long id){
		estadoCompraLogicService.deleteEstadoCompra(id);
	}
	
	@GET
	public List<EstadoCompraDTO> getEstadoCompras(){
		return estadoCompraLogicService.getEstadoCompras();
	}
	
	@GET
	@Path("{id}")
	public EstadoCompraDTO getEstadoCompra(@PathParam("id") Long id){
		return estadoCompraLogicService.getEstadoCompra(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateEstadoCompra(@PathParam("id") Long id, EstadoCompraDTO estadoCompra){
		estadoCompraLogicService.updateEstadoCompra(estadoCompra);
	}
	
}