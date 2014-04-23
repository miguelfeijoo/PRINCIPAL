
package co.edu.uniandes.csw.cliente.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.cliente.persistence.entity.ClienteEntity;

public abstract class _ClienteConverter {


	public static ClienteDTO entity2PersistenceDTO(ClienteEntity entity){
		if (entity != null) {
			ClienteDTO dto = new ClienteDTO();
				dto.setId(entity.getId());
				dto.setNombre(entity.getNombre());
                                dto.setContrasenia(entity.getContrasenia());
				dto.setDocumento(entity.getDocumento());
				dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static ClienteEntity persistenceDTO2Entity(ClienteDTO dto){
		if(dto!=null){
			ClienteEntity entity=new ClienteEntity();
			entity.setId(dto.getId());
			entity.setNombre(dto.getNombre());
                        entity.setContrasenia(dto.getContrasenia());
			entity.setDocumento(dto.getDocumento());
			entity.setName(dto.getName());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<ClienteDTO> entity2PersistenceDTOList(List<ClienteEntity> entities){
		List<ClienteDTO> dtos=new ArrayList<ClienteDTO>();
		for(ClienteEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<ClienteEntity> persistenceDTO2EntityList(List<ClienteDTO> dtos){
		List<ClienteEntity> entities=new ArrayList<ClienteEntity>();
		for(ClienteDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}