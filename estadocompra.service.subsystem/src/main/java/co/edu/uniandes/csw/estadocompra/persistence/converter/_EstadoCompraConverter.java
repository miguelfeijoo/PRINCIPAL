
package co.edu.uniandes.csw.estadocompra.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.estadocompra.logic.dto.EstadoCompraDTO;
import co.edu.uniandes.csw.estadocompra.persistence.entity.EstadoCompraEntity;

public abstract class _EstadoCompraConverter {


	public static EstadoCompraDTO entity2PersistenceDTO(EstadoCompraEntity entity){
		if (entity != null) {
			EstadoCompraDTO dto = new EstadoCompraDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static EstadoCompraEntity persistenceDTO2Entity(EstadoCompraDTO dto){
		if(dto!=null){
			EstadoCompraEntity entity=new EstadoCompraEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<EstadoCompraDTO> entity2PersistenceDTOList(List<EstadoCompraEntity> entities){
		List<EstadoCompraDTO> dtos=new ArrayList<EstadoCompraDTO>();
		for(EstadoCompraEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<EstadoCompraEntity> persistenceDTO2EntityList(List<EstadoCompraDTO> dtos){
		List<EstadoCompraEntity> entities=new ArrayList<EstadoCompraEntity>();
		for(EstadoCompraDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}