
package co.edu.uniandes.csw.componenteventasenlinea.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.api._IComponenteVentasEnLineaPersistence;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.converter.ComponenteVentasEnLineaConverter;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.entity.ComponenteVentasEnLineaEntity;

public abstract class _ComponenteVentasEnLineaPersistence implements _IComponenteVentasEnLineaPersistence {

	@PersistenceContext(unitName="ComponenteVentasEnLineaPU")
	protected EntityManager entityManager;
	
	public ComponenteVentasEnLineaDTO createComponenteVentasEnLinea(ComponenteVentasEnLineaDTO componenteVentasEnLinea) {
		ComponenteVentasEnLineaEntity entity=ComponenteVentasEnLineaConverter.persistenceDTO2Entity(componenteVentasEnLinea);
		entityManager.persist(entity);
		return ComponenteVentasEnLineaConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<ComponenteVentasEnLineaDTO> getComponenteVentasEnLineas() {
		Query q = entityManager.createQuery("select u from ComponenteVentasEnLineaEntity u");
		return ComponenteVentasEnLineaConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public ComponenteVentasEnLineaDTO getComponenteVentasEnLinea(Long id) {
		return ComponenteVentasEnLineaConverter.entity2PersistenceDTO(entityManager.find(ComponenteVentasEnLineaEntity.class, id));
	}

	public void deleteComponenteVentasEnLinea(Long id) {
		ComponenteVentasEnLineaEntity entity=entityManager.find(ComponenteVentasEnLineaEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateComponenteVentasEnLinea(ComponenteVentasEnLineaDTO detail) {
		ComponenteVentasEnLineaEntity entity=entityManager.merge(ComponenteVentasEnLineaConverter.persistenceDTO2Entity(detail));
		ComponenteVentasEnLineaConverter.entity2PersistenceDTO(entity);
	}

}