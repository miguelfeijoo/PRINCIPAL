
package co.edu.uniandes.csw.direccion.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;
import co.edu.uniandes.csw.direccion.persistence.api._IDireccionPersistence;
import co.edu.uniandes.csw.direccion.persistence.converter.DireccionConverter;
import co.edu.uniandes.csw.direccion.persistence.entity.DireccionEntity;

public abstract class _DireccionPersistence implements _IDireccionPersistence {

	@PersistenceContext(unitName="DireccionPU")
	protected EntityManager entityManager;
	
	public DireccionDTO createDireccion(DireccionDTO direccion) {
		DireccionEntity entity=DireccionConverter.persistenceDTO2Entity(direccion);
		entityManager.persist(entity);
		return DireccionConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<DireccionDTO> getDireccions() {
		Query q = entityManager.createQuery("select u from DireccionEntity u");
		return DireccionConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public DireccionDTO getDireccion(Long id) {
		return DireccionConverter.entity2PersistenceDTO(entityManager.find(DireccionEntity.class, id));
	}

	public void deleteDireccion(Long id) {
		DireccionEntity entity=entityManager.find(DireccionEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateDireccion(DireccionDTO detail) {
		DireccionEntity entity=entityManager.merge(DireccionConverter.persistenceDTO2Entity(detail));
		DireccionConverter.entity2PersistenceDTO(entity);
	}

}