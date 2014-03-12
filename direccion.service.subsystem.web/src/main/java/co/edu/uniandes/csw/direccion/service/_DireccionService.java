package co.edu.uniandes.csw.direccion.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.direccion.logic.api.IDireccionLogicService;
import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;


public abstract class _DireccionService {

	@Inject
	protected IDireccionLogicService direccionLogicService;
	
	@POST
	public DireccionDTO createDireccion(DireccionDTO direccion){
		return direccionLogicService.createDireccion(direccion);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteDireccion(@PathParam("id") Long id){
		direccionLogicService.deleteDireccion(id);
	}
	
	@GET
	public List<DireccionDTO> getDireccions(){
		return direccionLogicService.getDireccions();
	}
	
	@GET
	@Path("{id}")
	public DireccionDTO getDireccion(@PathParam("id") Long id){
		return direccionLogicService.getDireccion(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateDireccion(@PathParam("id") Long id, DireccionDTO direccion){
		direccionLogicService.updateDireccion(direccion);
	}
	
}