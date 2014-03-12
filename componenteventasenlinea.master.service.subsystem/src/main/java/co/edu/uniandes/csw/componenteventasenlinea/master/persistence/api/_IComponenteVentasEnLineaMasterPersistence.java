package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.api;

import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaClienteEntity;
import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaProductoEntity;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaFacturaEntity;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaPromocionEntity;
import co.edu.uniandes.csw.promocion.logic.dto.PromocionDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.logic.dto.ComponenteVentasEnLineaMasterDTO;
import java.util.List;

public interface _IComponenteVentasEnLineaMasterPersistence {

    public ComponenteVentasEnLineaClienteEntity createComponenteVentasEnLineaCliente(ComponenteVentasEnLineaClienteEntity entity);

    public void deleteComponenteVentasEnLineaCliente(Long componenteventasenlineaId, Long clienteId);
    
    public List<ClienteDTO> getClienteListForComponenteVentasEnLinea(Long componenteventasenlineaId);
    public ComponenteVentasEnLineaProductoEntity createComponenteVentasEnLineaProducto(ComponenteVentasEnLineaProductoEntity entity);

    public void deleteComponenteVentasEnLineaProducto(Long componenteventasenlineaId, Long productoId);
    
    public List<ProductoDTO> getProductoListForComponenteVentasEnLinea(Long componenteventasenlineaId);
    public ComponenteVentasEnLineaFacturaEntity createComponenteVentasEnLineaFactura(ComponenteVentasEnLineaFacturaEntity entity);

    public void deleteComponenteVentasEnLineaFactura(Long componenteventasenlineaId, Long facturaId);
    
    public List<FacturaDTO> getFacturaListForComponenteVentasEnLinea(Long componenteventasenlineaId);
    public ComponenteVentasEnLineaPromocionEntity createComponenteVentasEnLineaPromocion(ComponenteVentasEnLineaPromocionEntity entity);

    public void deleteComponenteVentasEnLineaPromocion(Long componenteventasenlineaId, Long promocionId);
    
    public List<PromocionDTO> getPromocionListForComponenteVentasEnLinea(Long componenteventasenlineaId);
    
    public ComponenteVentasEnLineaMasterDTO getComponenteVentasEnLinea(Long componenteventasenlineaId);

}
