package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import co.edu.uniandes.csw.factura.persistence.entity.FacturaEntity;
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
@IdClass(ComponenteVentasEnLineaFacturaEntityId.class)
@NamedQueries({
    @NamedQuery(name = "ComponenteVentasEnLineaFacturaEntity.getFacturaListForComponenteVentasEnLinea", query = "SELECT  u FROM ComponenteVentasEnLineaFacturaEntity u WHERE u.componenteventasenlineaId=:componenteventasenlineaId"),
    @NamedQuery(name = "ComponenteVentasEnLineaFacturaEntity.deleteComponenteVentasEnLineaFactura", query = "DELETE FROM ComponenteVentasEnLineaFacturaEntity u WHERE u.facturaId=:facturaId and  u.componenteventasenlineaId=:componenteventasenlineaId")
})
public class ComponenteVentasEnLineaFacturaEntity implements Serializable {

    @Id
    @Column(name = "componenteventasenlineaId")
    private Long componenteventasenlineaId;
    @Id
    @Column(name = "facturaId")
    private Long facturaId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "facturaId", referencedColumnName = "id")
    @JoinFetch
    private FacturaEntity facturaEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "componenteventasenlineaId", referencedColumnName = "id")
    @JoinFetch
    private ComponenteVentasEnLineaEntity componenteventasenlineaEntity;

    public ComponenteVentasEnLineaFacturaEntity() {
    }

    public ComponenteVentasEnLineaFacturaEntity(Long componenteventasenlineaId, Long facturaId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
        this.facturaId = facturaId;
    }

    public Long getComponenteVentasEnLineaId() {
        return componenteventasenlineaId;
    }

    public void setComponenteVentasEnLineaId(Long componenteventasenlineaId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public FacturaEntity getFacturaEntity() {
        return facturaEntity;
    }

    public void setFacturaEntity(FacturaEntity facturaEntity) {
        this.facturaEntity = facturaEntity;
    }

    public ComponenteVentasEnLineaEntity getComponenteVentasEnLineaEntity() {
        return componenteventasenlineaEntity;
    }

    public void setComponenteVentasEnLineaEntity(ComponenteVentasEnLineaEntity componenteventasenlineaEntity) {
        this.componenteventasenlineaEntity = componenteventasenlineaEntity;
    }

}
