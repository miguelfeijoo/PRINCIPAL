package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import co.edu.uniandes.csw.producto.persistence.entity.ProductoEntity;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.entity.ComponenteVentasEnLineaEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(ComponenteVentasEnLineaProductoEntityId.class)
@NamedQueries({
    @NamedQuery(name = "ComponenteVentasEnLineaProductoEntity.getProductoListForComponenteVentasEnLinea", query = "SELECT  u FROM ComponenteVentasEnLineaProductoEntity u WHERE u.componenteventasenlineaId=:componenteventasenlineaId"),
    @NamedQuery(name = "ComponenteVentasEnLineaProductoEntity.deleteComponenteVentasEnLineaProducto", query = "DELETE FROM ComponenteVentasEnLineaProductoEntity u WHERE u.productoId=:productoId and  u.componenteventasenlineaId=:componenteventasenlineaId")
})
public class ComponenteVentasEnLineaProductoEntity implements Serializable {

    @Id
    @Column(name = "componenteventasenlineaId")
    private Long componenteventasenlineaId;
    @Id
    @Column(name = "productoId")
    private Long productoId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "productoId", referencedColumnName = "id")
    @JoinFetch
    private ProductoEntity productoEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "componenteventasenlineaId", referencedColumnName = "id")
    @JoinFetch
    private ComponenteVentasEnLineaEntity componenteventasenlineaEntity;

    public ComponenteVentasEnLineaProductoEntity() {
    }

    public ComponenteVentasEnLineaProductoEntity(Long componenteventasenlineaId, Long productoId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
        this.productoId = productoId;
    }

    public Long getComponenteVentasEnLineaId() {
        return componenteventasenlineaId;
    }

    public void setComponenteVentasEnLineaId(Long componenteventasenlineaId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public ProductoEntity getProductoEntity() {
        return productoEntity;
    }

    public void setProductoEntity(ProductoEntity productoEntity) {
        this.productoEntity = productoEntity;
    }

    public ComponenteVentasEnLineaEntity getComponenteVentasEnLineaEntity() {
        return componenteventasenlineaEntity;
    }

    public void setComponenteVentasEnLineaEntity(ComponenteVentasEnLineaEntity componenteventasenlineaEntity) {
        this.componenteventasenlineaEntity = componenteventasenlineaEntity;
    }

}
