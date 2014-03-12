package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.converter;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaClienteEntity;
import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.cliente.persistence.converter.ClienteConverter;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaProductoEntity;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.producto.persistence.converter.ProductoConverter;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaFacturaEntity;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.factura.persistence.converter.FacturaConverter;
import co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity.ComponenteVentasEnLineaPromocionEntity;
import co.edu.uniandes.csw.promocion.logic.dto.PromocionDTO;
import co.edu.uniandes.csw.promocion.persistence.converter.PromocionConverter;
import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.master.logic.dto.ComponenteVentasEnLineaMasterDTO;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.converter.ComponenteVentasEnLineaConverter;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.entity.ComponenteVentasEnLineaEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _ComponenteVentasEnLineaMasterConverter {

    public static ComponenteVentasEnLineaMasterDTO entity2PersistenceDTO(ComponenteVentasEnLineaEntity componenteventasenlineaEntity 
    ,List<ComponenteVentasEnLineaClienteEntity> componenteventasenlineaClienteEntity 
    ,List<ComponenteVentasEnLineaProductoEntity> componenteventasenlineaProductoEntity 
    ,List<ComponenteVentasEnLineaFacturaEntity> componenteventasenlineaFacturaEntity 
    ,List<ComponenteVentasEnLineaPromocionEntity> componenteventasenlineaPromocionEntity 
    ) {
        ComponenteVentasEnLineaDTO componenteventasenlineaDTO = ComponenteVentasEnLineaConverter.entity2PersistenceDTO(componenteventasenlineaEntity);
        ArrayList<ClienteDTO> clienteEntities = new ArrayList<ClienteDTO>(componenteventasenlineaClienteEntity.size());
        for (ComponenteVentasEnLineaClienteEntity componenteventasenlineaCliente : componenteventasenlineaClienteEntity) {
            clienteEntities.add(ClienteConverter.entity2PersistenceDTO(componenteventasenlineaCliente.getClienteEntity()));
        }
        ArrayList<ProductoDTO> productoEntities = new ArrayList<ProductoDTO>(componenteventasenlineaProductoEntity.size());
        for (ComponenteVentasEnLineaProductoEntity componenteventasenlineaProducto : componenteventasenlineaProductoEntity) {
            productoEntities.add(ProductoConverter.entity2PersistenceDTO(componenteventasenlineaProducto.getProductoEntity()));
        }
        ArrayList<FacturaDTO> facturaEntities = new ArrayList<FacturaDTO>(componenteventasenlineaFacturaEntity.size());
        for (ComponenteVentasEnLineaFacturaEntity componenteventasenlineaFactura : componenteventasenlineaFacturaEntity) {
            facturaEntities.add(FacturaConverter.entity2PersistenceDTO(componenteventasenlineaFactura.getFacturaEntity()));
        }
        ArrayList<PromocionDTO> promocionEntities = new ArrayList<PromocionDTO>(componenteventasenlineaPromocionEntity.size());
        for (ComponenteVentasEnLineaPromocionEntity componenteventasenlineaPromocion : componenteventasenlineaPromocionEntity) {
            promocionEntities.add(PromocionConverter.entity2PersistenceDTO(componenteventasenlineaPromocion.getPromocionEntity()));
        }
        ComponenteVentasEnLineaMasterDTO respDTO  = new ComponenteVentasEnLineaMasterDTO();
        respDTO.setComponenteVentasEnLineaEntity(componenteventasenlineaDTO);
        respDTO.setListCliente(clienteEntities);
        respDTO.setListProducto(productoEntities);
        respDTO.setListFactura(facturaEntities);
        respDTO.setListPromocion(promocionEntities);
        return respDTO;
    }

}