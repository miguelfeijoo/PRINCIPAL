
package co.edu.uniandes.csw.estadocompra.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.estadocompra.logic.dto.EstadoCompraDTO;
import co.edu.uniandes.csw.estadocompra.persistence.api._IEstadoCompraPersistence;
import co.edu.uniandes.csw.estadocompra.persistence.converter.EstadoCompraConverter;
import co.edu.uniandes.csw.estadocompra.persistence.entity.EstadoCompraEntity;

public abstract class _EstadoCompraPersistence implements _IEstadoCompraPersistence {

	@PersistenceContext(unitName="EstadoCompraPU")
	protected EntityManager entityManager;
	
	public EstadoCompraDTO createEstadoCompra(EstadoCompraDTO estadoCompra) {
		EstadoCompraEntity entity=EstadoCompraConverter.persistenceDTO2Entity(estadoCompra);
		entityManager.persist(entity);
		return EstadoCompraConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<EstadoCompraDTO> getEstadoCompras() {
		Query q = entityManager.createQuery("select u from EstadoCompraEntity u");
		return EstadoCompraConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public EstadoCompraDTO getEstadoCompra(Long id) {
		return EstadoCompraConverter.entity2PersistenceDTO(entityManager.find(EstadoCompraEntity.class, id));
	}

	public void deleteEstadoCompra(Long id) {
		EstadoCompraEntity entity=entityManager.find(EstadoCompraEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateEstadoCompra(EstadoCompraDTO detail) {
		EstadoCompraEntity entity=entityManager.merge(EstadoCompraConverter.persistenceDTO2Entity(detail));
		EstadoCompraConverter.entity2PersistenceDTO(entity);
	}

}