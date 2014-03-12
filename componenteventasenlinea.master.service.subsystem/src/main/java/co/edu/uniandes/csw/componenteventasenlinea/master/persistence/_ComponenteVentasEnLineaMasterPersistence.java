package co.edu.uniandes.csw.componenteventasenlinea.master.persistence;
import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaClienteEntity;
import co.edu.uniandes.csw.cliente.persistence.converter.ClienteConverter;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaProductoEntity;
import co.edu.uniandes.csw.producto.persistence.converter.ProductoConverter;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaFacturaEntity;
import co.edu.uniandes.csw.factura.persistence.converter.FacturaConverter;
import co.edu.uniandes.csw.promocion.logic.dto.PromocionDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaPromocionEntity;
import co.edu.uniandes.csw.promocion.persistence.converter.PromocionConverter;
import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.logic.dto.ComponenteVentasEnLineaMasterDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.api._IComponenteVentasEnLineaMasterPersistence;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.api.IComponenteVentasEnLineaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _ComponenteVentasEnLineaMasterPersistence implements _IComponenteVentasEnLineaMasterPersistence {

    @PersistenceContext(unitName = "ComponenteVentasEnLineaMasterPU")
    protected EntityManager entityManager;
    
    @Inject
    protected IComponenteVentasEnLineaPersistence componenteventasenlineaPersistence;  

    public ComponenteVentasEnLineaMasterDTO getComponenteVentasEnLinea(Long componenteventasenlineaId) {
        ComponenteVentasEnLineaMasterDTO componenteventasenlineaMasterDTO = new ComponenteVentasEnLineaMasterDTO();
        ComponenteVentasEnLineaDTO componenteventasenlinea = componenteventasenlineaPersistence.getComponenteVentasEnLinea(componenteventasenlineaId);
        componenteventasenlineaMasterDTO.setComponenteVentasEnLineaEntity(componenteventasenlinea);
        componenteventasenlineaMasterDTO.setListCliente(getClienteListForComponenteVentasEnLinea(componenteventasenlineaId));
        componenteventasenlineaMasterDTO.setListProducto(getProductoListForComponenteVentasEnLinea(componenteventasenlineaId));
        componenteventasenlineaMasterDTO.setListFactura(getFacturaListForComponenteVentasEnLinea(componenteventasenlineaId));
        componenteventasenlineaMasterDTO.setListPromocion(getPromocionListForComponenteVentasEnLinea(componenteventasenlineaId));
        return componenteventasenlineaMasterDTO;
    }

    public ComponenteVentasEnLineaClienteEntity createComponenteVentasEnLineaCliente(ComponenteVentasEnLineaClienteEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteComponenteVentasEnLineaCliente(Long componenteventasenlineaId, Long clienteId) {
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaClienteEntity.deleteComponenteVentasEnLineaCliente");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        q.setParameter("clienteId", clienteId);
        q.executeUpdate();
    }

    public List<ClienteDTO> getClienteListForComponenteVentasEnLinea(Long componenteventasenlineaId) {
        ArrayList<ClienteDTO> resp = new ArrayList<ClienteDTO>();
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaClienteEntity.getClienteListForComponenteVentasEnLinea");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        List<ComponenteVentasEnLineaClienteEntity> qResult =  q.getResultList();
        for (ComponenteVentasEnLineaClienteEntity componenteventasenlineaClienteEntity : qResult) { 
            if(componenteventasenlineaClienteEntity.getClienteEntity()==null){
                entityManager.refresh(componenteventasenlineaClienteEntity);
            }
            resp.add(ClienteConverter.entity2PersistenceDTO(componenteventasenlineaClienteEntity.getClienteEntity()));
        }
        return resp;
    }
    public ComponenteVentasEnLineaProductoEntity createComponenteVentasEnLineaProducto(ComponenteVentasEnLineaProductoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteComponenteVentasEnLineaProducto(Long componenteventasenlineaId, Long productoId) {
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaProductoEntity.deleteComponenteVentasEnLineaProducto");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        q.setParameter("productoId", productoId);
        q.executeUpdate();
    }

    public List<ProductoDTO> getProductoListForComponenteVentasEnLinea(Long componenteventasenlineaId) {
        ArrayList<ProductoDTO> resp = new ArrayList<ProductoDTO>();
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaProductoEntity.getProductoListForComponenteVentasEnLinea");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        List<ComponenteVentasEnLineaProductoEntity> qResult =  q.getResultList();
        for (ComponenteVentasEnLineaProductoEntity componenteventasenlineaProductoEntity : qResult) { 
            if(componenteventasenlineaProductoEntity.getProductoEntity()==null){
                entityManager.refresh(componenteventasenlineaProductoEntity);
            }
            resp.add(ProductoConverter.entity2PersistenceDTO(componenteventasenlineaProductoEntity.getProductoEntity()));
        }
        return resp;
    }
    public ComponenteVentasEnLineaFacturaEntity createComponenteVentasEnLineaFactura(ComponenteVentasEnLineaFacturaEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteComponenteVentasEnLineaFactura(Long componenteventasenlineaId, Long facturaId) {
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaFacturaEntity.deleteComponenteVentasEnLineaFactura");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        q.setParameter("facturaId", facturaId);
        q.executeUpdate();
    }

    public List<FacturaDTO> getFacturaListForComponenteVentasEnLinea(Long componenteventasenlineaId) {
        ArrayList<FacturaDTO> resp = new ArrayList<FacturaDTO>();
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaFacturaEntity.getFacturaListForComponenteVentasEnLinea");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        List<ComponenteVentasEnLineaFacturaEntity> qResult =  q.getResultList();
        for (ComponenteVentasEnLineaFacturaEntity componenteventasenlineaFacturaEntity : qResult) { 
            if(componenteventasenlineaFacturaEntity.getFacturaEntity()==null){
                entityManager.refresh(componenteventasenlineaFacturaEntity);
            }
            resp.add(FacturaConverter.entity2PersistenceDTO(componenteventasenlineaFacturaEntity.getFacturaEntity()));
        }
        return resp;
    }
    public ComponenteVentasEnLineaPromocionEntity createComponenteVentasEnLineaPromocion(ComponenteVentasEnLineaPromocionEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteComponenteVentasEnLineaPromocion(Long componenteventasenlineaId, Long promocionId) {
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaPromocionEntity.deleteComponenteVentasEnLineaPromocion");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        q.setParameter("promocionId", promocionId);
        q.executeUpdate();
    }

    public List<PromocionDTO> getPromocionListForComponenteVentasEnLinea(Long componenteventasenlineaId) {
        ArrayList<PromocionDTO> resp = new ArrayList<PromocionDTO>();
        Query q = entityManager.createNamedQuery("ComponenteVentasEnLineaPromocionEntity.getPromocionListForComponenteVentasEnLinea");
        q.setParameter("componenteventasenlineaId", componenteventasenlineaId);
        List<ComponenteVentasEnLineaPromocionEntity> qResult =  q.getResultList();
        for (ComponenteVentasEnLineaPromocionEntity componenteventasenlineaPromocionEntity : qResult) { 
            if(componenteventasenlineaPromocionEntity.getPromocionEntity()==null){
                entityManager.refresh(componenteventasenlineaPromocionEntity);
            }
            resp.add(PromocionConverter.entity2PersistenceDTO(componenteventasenlineaPromocionEntity.getPromocionEntity()));
        }
        return resp;
    }

}
