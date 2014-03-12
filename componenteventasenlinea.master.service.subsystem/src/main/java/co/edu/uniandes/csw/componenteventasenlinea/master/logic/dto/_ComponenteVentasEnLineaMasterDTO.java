package co.edu.uniandes.csw.componenteventasenlinea.master.logic.dto;

import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import co.edu.uniandes.csw.factura.logic.dto.FacturaDTO;
import co.edu.uniandes.csw.promocion.logic.dto.PromocionDTO;
import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class _ComponenteVentasEnLineaMasterDTO {

 
    protected ComponenteVentasEnLineaDTO componenteventasenlineaEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public ComponenteVentasEnLineaDTO getComponenteVentasEnLineaEntity() {
        return componenteventasenlineaEntity;
    }

    public void setComponenteVentasEnLineaEntity(ComponenteVentasEnLineaDTO componenteventasenlineaEntity) {
        this.componenteventasenlineaEntity = componenteventasenlineaEntity;
    }
    
    public List<ClienteDTO> createCliente;
    public List<ClienteDTO> updateCliente;
    public List<ClienteDTO> deleteCliente;
    public List<ClienteDTO> listCliente;	
    public List<ProductoDTO> createProducto;
    public List<ProductoDTO> updateProducto;
    public List<ProductoDTO> deleteProducto;
    public List<ProductoDTO> listProducto;	
    public List<FacturaDTO> createFactura;
    public List<FacturaDTO> updateFactura;
    public List<FacturaDTO> deleteFactura;
    public List<FacturaDTO> listFactura;	
    public List<PromocionDTO> createPromocion;
    public List<PromocionDTO> updatePromocion;
    public List<PromocionDTO> deletePromocion;
    public List<PromocionDTO> listPromocion;	
	
	
	
    public List<ClienteDTO> getCreateCliente(){ return createCliente; };
    public void setCreateCliente(List<ClienteDTO> createCliente){ this.createCliente=createCliente; };
    public List<ClienteDTO> getUpdateCliente(){ return updateCliente; };
    public void setUpdateCliente(List<ClienteDTO> updateCliente){ this.updateCliente=updateCliente; };
    public List<ClienteDTO> getDeleteCliente(){ return deleteCliente; };
    public void setDeleteCliente(List<ClienteDTO> deleteCliente){ this.deleteCliente=deleteCliente; };
    public List<ClienteDTO> getListCliente(){ return listCliente; };
    public void setListCliente(List<ClienteDTO> listCliente){ this.listCliente=listCliente; };	
    public List<ProductoDTO> getCreateProducto(){ return createProducto; };
    public void setCreateProducto(List<ProductoDTO> createProducto){ this.createProducto=createProducto; };
    public List<ProductoDTO> getUpdateProducto(){ return updateProducto; };
    public void setUpdateProducto(List<ProductoDTO> updateProducto){ this.updateProducto=updateProducto; };
    public List<ProductoDTO> getDeleteProducto(){ return deleteProducto; };
    public void setDeleteProducto(List<ProductoDTO> deleteProducto){ this.deleteProducto=deleteProducto; };
    public List<ProductoDTO> getListProducto(){ return listProducto; };
    public void setListProducto(List<ProductoDTO> listProducto){ this.listProducto=listProducto; };	
    public List<FacturaDTO> getCreateFactura(){ return createFactura; };
    public void setCreateFactura(List<FacturaDTO> createFactura){ this.createFactura=createFactura; };
    public List<FacturaDTO> getUpdateFactura(){ return updateFactura; };
    public void setUpdateFactura(List<FacturaDTO> updateFactura){ this.updateFactura=updateFactura; };
    public List<FacturaDTO> getDeleteFactura(){ return deleteFactura; };
    public void setDeleteFactura(List<FacturaDTO> deleteFactura){ this.deleteFactura=deleteFactura; };
    public List<FacturaDTO> getListFactura(){ return listFactura; };
    public void setListFactura(List<FacturaDTO> listFactura){ this.listFactura=listFactura; };	
    public List<PromocionDTO> getCreatePromocion(){ return createPromocion; };
    public void setCreatePromocion(List<PromocionDTO> createPromocion){ this.createPromocion=createPromocion; };
    public List<PromocionDTO> getUpdatePromocion(){ return updatePromocion; };
    public void setUpdatePromocion(List<PromocionDTO> updatePromocion){ this.updatePromocion=updatePromocion; };
    public List<PromocionDTO> getDeletePromocion(){ return deletePromocion; };
    public void setDeletePromocion(List<PromocionDTO> deletePromocion){ this.deletePromocion=deletePromocion; };
    public List<PromocionDTO> getListPromocion(){ return listPromocion; };
    public void setListPromocion(List<PromocionDTO> listPromocion){ this.listPromocion=listPromocion; };	
	
	
}

