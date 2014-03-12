package co.edu.uniandes.csw.componenteventasenlinea.master.logic.ejb;

import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.cliente.persistence.api.IClientePersistence;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.producto.persistence.api.IProductoPersistence;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.persistence.api.IFacturaPersistence;
import co.edu.uniandes.csw.promocion.logic.dto.PromocionDTO;
import co.edu.uniandes.csw.promocion.persistence.api.IPromocionPersistence;
import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.logic.api._IComponenteVentasEnLineaMasterLogicService;
import co.edu.uniandes.csw.componenteventasenlinea.master.logic.dto.ComponenteVentasEnLineaMasterDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.api.IComponenteVentasEnLineaMasterPersistence;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaClienteEntity;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaProductoEntity;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaFacturaEntity;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaPromocionEntity;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.api.IComponenteVentasEnLineaPersistence;
import javax.inject.Inject;

public abstract class _ComponenteVentasEnLineaMasterLogicService implements _IComponenteVentasEnLineaMasterLogicService {

    @Inject
    protected IComponenteVentasEnLineaPersistence componenteventasenlineaPersistance;
    @Inject
    protected IComponenteVentasEnLineaMasterPersistence componenteventasenlineaMasterPersistance;
    @Inject
    protected IClientePersistence clientePersistance;
    @Inject
    protected IProductoPersistence productoPersistance;
    @Inject
    protected IFacturaPersistence facturaPersistance;
    @Inject
    protected IPromocionPersistence promocionPersistance;

    public ComponenteVentasEnLineaMasterDTO createMasterComponenteVentasEnLinea(ComponenteVentasEnLineaMasterDTO componenteventasenlinea) {
        ComponenteVentasEnLineaDTO persistedComponenteVentasEnLineaDTO = componenteventasenlineaPersistance.createComponenteVentasEnLinea(componenteventasenlinea.getComponenteVentasEnLineaEntity());
        if (componenteventasenlinea.getCreateCliente() != null) {
            for (ClienteDTO clienteDTO : componenteventasenlinea.getCreateCliente()) {
                ClienteDTO persistedClienteDTO = clientePersistance.createCliente(clienteDTO);
                ComponenteVentasEnLineaClienteEntity componenteventasenlineaClienteEntity = new ComponenteVentasEnLineaClienteEntity(persistedComponenteVentasEnLineaDTO.getId(), persistedClienteDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaCliente(componenteventasenlineaClienteEntity);
            }
        }
        if (componenteventasenlinea.getCreateProducto() != null) {
            for (ProductoDTO productoDTO : componenteventasenlinea.getCreateProducto()) {
                ProductoDTO persistedProductoDTO = productoPersistance.createProducto(productoDTO);
                ComponenteVentasEnLineaProductoEntity componenteventasenlineaProductoEntity = new ComponenteVentasEnLineaProductoEntity(persistedComponenteVentasEnLineaDTO.getId(), persistedProductoDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaProducto(componenteventasenlineaProductoEntity);
            }
        }
        if (componenteventasenlinea.getCreateFactura() != null) {
            for (FacturaDTO facturaDTO : componenteventasenlinea.getCreateFactura()) {
                FacturaDTO persistedFacturaDTO = facturaPersistance.createFactura(facturaDTO);
                ComponenteVentasEnLineaFacturaEntity componenteventasenlineaFacturaEntity = new ComponenteVentasEnLineaFacturaEntity(persistedComponenteVentasEnLineaDTO.getId(), persistedFacturaDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaFactura(componenteventasenlineaFacturaEntity);
            }
        }
        if (componenteventasenlinea.getCreatePromocion() != null) {
            for (PromocionDTO promocionDTO : componenteventasenlinea.getCreatePromocion()) {
                PromocionDTO persistedPromocionDTO = promocionPersistance.createPromocion(promocionDTO);
                ComponenteVentasEnLineaPromocionEntity componenteventasenlineaPromocionEntity = new ComponenteVentasEnLineaPromocionEntity(persistedComponenteVentasEnLineaDTO.getId(), persistedPromocionDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaPromocion(componenteventasenlineaPromocionEntity);
            }
        }
        return componenteventasenlinea;
    }

    public ComponenteVentasEnLineaMasterDTO getMasterComponenteVentasEnLinea(Long id) {
        return componenteventasenlineaMasterPersistance.getComponenteVentasEnLinea(id);
    }

    public void deleteMasterComponenteVentasEnLinea(Long id) {
        componenteventasenlineaPersistance.deleteComponenteVentasEnLinea(id);
    }

    public void updateMasterComponenteVentasEnLinea(ComponenteVentasEnLineaMasterDTO componenteventasenlinea) {
        componenteventasenlineaPersistance.updateComponenteVentasEnLinea(componenteventasenlinea.getComponenteVentasEnLineaEntity());

        //---- FOR RELATIONSHIP
        // persist new cliente
        if (componenteventasenlinea.getCreateCliente() != null) {
            for (ClienteDTO clienteDTO : componenteventasenlinea.getCreateCliente()) {
                ClienteDTO persistedClienteDTO = clientePersistance.createCliente(clienteDTO);
                ComponenteVentasEnLineaClienteEntity componenteventasenlineaClienteEntity = new ComponenteVentasEnLineaClienteEntity(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), persistedClienteDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaCliente(componenteventasenlineaClienteEntity);
            }
        }
        // update cliente
        if (componenteventasenlinea.getUpdateCliente() != null) {
            for (ClienteDTO clienteDTO : componenteventasenlinea.getUpdateCliente()) {
                clientePersistance.updateCliente(clienteDTO);
            }
        }
        // delete cliente
        if (componenteventasenlinea.getDeleteCliente() != null) {
            for (ClienteDTO clienteDTO : componenteventasenlinea.getDeleteCliente()) {
                componenteventasenlineaMasterPersistance.deleteComponenteVentasEnLineaCliente(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), clienteDTO.getId());
                clientePersistance.deleteCliente(clienteDTO.getId());
            }
        }
        // persist new producto
        if (componenteventasenlinea.getCreateProducto() != null) {
            for (ProductoDTO productoDTO : componenteventasenlinea.getCreateProducto()) {
                ProductoDTO persistedProductoDTO = productoPersistance.createProducto(productoDTO);
                ComponenteVentasEnLineaProductoEntity componenteventasenlineaProductoEntity = new ComponenteVentasEnLineaProductoEntity(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), persistedProductoDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaProducto(componenteventasenlineaProductoEntity);
            }
        }
        // update producto
        if (componenteventasenlinea.getUpdateProducto() != null) {
            for (ProductoDTO productoDTO : componenteventasenlinea.getUpdateProducto()) {
                productoPersistance.updateProducto(productoDTO);
            }
        }
        // delete producto
        if (componenteventasenlinea.getDeleteProducto() != null) {
            for (ProductoDTO productoDTO : componenteventasenlinea.getDeleteProducto()) {
                componenteventasenlineaMasterPersistance.deleteComponenteVentasEnLineaProducto(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), productoDTO.getId());
                productoPersistance.deleteProducto(productoDTO.getId());
            }
        }
        // persist new factura
        if (componenteventasenlinea.getCreateFactura() != null) {
            for (FacturaDTO facturaDTO : componenteventasenlinea.getCreateFactura()) {
                FacturaDTO persistedFacturaDTO = facturaPersistance.createFactura(facturaDTO);
                ComponenteVentasEnLineaFacturaEntity componenteventasenlineaFacturaEntity = new ComponenteVentasEnLineaFacturaEntity(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), persistedFacturaDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaFactura(componenteventasenlineaFacturaEntity);
            }
        }
        // update factura
        if (componenteventasenlinea.getUpdateFactura() != null) {
            for (FacturaDTO facturaDTO : componenteventasenlinea.getUpdateFactura()) {
                facturaPersistance.updateFactura(facturaDTO);
            }
        }
        // delete factura
        if (componenteventasenlinea.getDeleteFactura() != null) {
            for (FacturaDTO facturaDTO : componenteventasenlinea.getDeleteFactura()) {
                componenteventasenlineaMasterPersistance.deleteComponenteVentasEnLineaFactura(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), facturaDTO.getId());
                facturaPersistance.deleteFactura(facturaDTO.getId());
            }
        }
        // persist new promocion
        if (componenteventasenlinea.getCreatePromocion() != null) {
            for (PromocionDTO promocionDTO : componenteventasenlinea.getCreatePromocion()) {
                PromocionDTO persistedPromocionDTO = promocionPersistance.createPromocion(promocionDTO);
                ComponenteVentasEnLineaPromocionEntity componenteventasenlineaPromocionEntity = new ComponenteVentasEnLineaPromocionEntity(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), persistedPromocionDTO.getId());
                componenteventasenlineaMasterPersistance.createComponenteVentasEnLineaPromocion(componenteventasenlineaPromocionEntity);
            }
        }
        // update promocion
        if (componenteventasenlinea.getUpdatePromocion() != null) {
            for (PromocionDTO promocionDTO : componenteventasenlinea.getUpdatePromocion()) {
                promocionPersistance.updatePromocion(promocionDTO);
            }
        }
        // delete promocion
        if (componenteventasenlinea.getDeletePromocion() != null) {
            for (PromocionDTO promocionDTO : componenteventasenlinea.getDeletePromocion()) {
                componenteventasenlineaMasterPersistance.deleteComponenteVentasEnLineaPromocion(componenteventasenlinea.getComponenteVentasEnLineaEntity().getId(), promocionDTO.getId());
                promocionPersistance.deletePromocion(promocionDTO.getId());
            }
        }
    }
}
