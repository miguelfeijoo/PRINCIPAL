
package co.edu.uniandes.csw.componenteventasenlinea.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.entity.ComponenteVentasEnLineaEntity;

public abstract class _ComponenteVentasEnLineaConverter {


	public static ComponenteVentasEnLineaDTO entity2PersistenceDTO(ComponenteVentasEnLineaEntity entity){
		if (entity != null) {
			ComponenteVentasEnLineaDTO dto = new ComponenteVentasEnLineaDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setProductoId(entity.getProductoId());
			return dto;
		}else{
			return null;
		}
	}
	
	public static ComponenteVentasEnLineaEntity persistenceDTO2Entity(ComponenteVentasEnLineaDTO dto){
		if(dto!=null){
			ComponenteVentasEnLineaEntity entity=new ComponenteVentasEnLineaEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setProductoId(dto.getProductoId());
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<ComponenteVentasEnLineaDTO> entity2PersistenceDTOList(List<ComponenteVentasEnLineaEntity> entities){
		List<ComponenteVentasEnLineaDTO> dtos=new ArrayList<ComponenteVentasEnLineaDTO>();
		for(ComponenteVentasEnLineaEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<ComponenteVentasEnLineaEntity> persistenceDTO2EntityList(List<ComponenteVentasEnLineaDTO> dtos){
		List<ComponenteVentasEnLineaEntity> entities=new ArrayList<ComponenteVentasEnLineaEntity>();
		for(ComponenteVentasEnLineaDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}