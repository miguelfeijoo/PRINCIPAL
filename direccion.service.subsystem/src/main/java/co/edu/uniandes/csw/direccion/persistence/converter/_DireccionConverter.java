
package co.edu.uniandes.csw.direccion.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;
import co.edu.uniandes.csw.direccion.persistence.entity.DireccionEntity;

public abstract class _DireccionConverter {


	public static DireccionDTO entity2PersistenceDTO(DireccionEntity entity){
		if (entity != null) {
			DireccionDTO dto = new DireccionDTO();
				dto.setId(entity.getId());
				dto.setDireccion(entity.getDireccion());
				dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static DireccionEntity persistenceDTO2Entity(DireccionDTO dto){
		if(dto!=null){
			DireccionEntity entity=new DireccionEntity();
			entity.setId(dto.getId());
			entity.setDireccion(dto.getDireccion());
			entity.setName(dto.getName());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<DireccionDTO> entity2PersistenceDTOList(List<DireccionEntity> entities){
		List<DireccionDTO> dtos=new ArrayList<DireccionDTO>();
		for(DireccionEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<DireccionEntity> persistenceDTO2EntityList(List<DireccionDTO> dtos){
		List<DireccionEntity> entities=new ArrayList<DireccionEntity>();
		for(DireccionDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}