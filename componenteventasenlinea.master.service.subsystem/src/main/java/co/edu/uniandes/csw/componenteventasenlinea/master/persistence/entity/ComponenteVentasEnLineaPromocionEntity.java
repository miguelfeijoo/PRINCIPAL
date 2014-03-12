package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import co.edu.uniandes.csw.promocion.persistence.entity.PromocionEntity;
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
@IdClass(ComponenteVentasEnLineaPromocionEntityId.class)
@NamedQueries({
    @NamedQuery(name = "ComponenteVentasEnLineaPromocionEntity.getPromocionListForComponenteVentasEnLinea", query = "SELECT  u FROM ComponenteVentasEnLineaPromocionEntity u WHERE u.componenteventasenlineaId=:componenteventasenlineaId"),
    @NamedQuery(name = "ComponenteVentasEnLineaPromocionEntity.deleteComponenteVentasEnLineaPromocion", query = "DELETE FROM ComponenteVentasEnLineaPromocionEntity u WHERE u.promocionId=:promocionId and  u.componenteventasenlineaId=:componenteventasenlineaId")
})
public class ComponenteVentasEnLineaPromocionEntity implements Serializable {

    @Id
    @Column(name = "componenteventasenlineaId")
    private Long componenteventasenlineaId;
    @Id
    @Column(name = "promocionId")
    private Long promocionId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "promocionId", referencedColumnName = "id")
    @JoinFetch
    private PromocionEntity promocionEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "componenteventasenlineaId", referencedColumnName = "id")
    @JoinFetch
    private ComponenteVentasEnLineaEntity componenteventasenlineaEntity;

    public ComponenteVentasEnLineaPromocionEntity() {
    }

    public ComponenteVentasEnLineaPromocionEntity(Long componenteventasenlineaId, Long promocionId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
        this.promocionId = promocionId;
    }

    public Long getComponenteVentasEnLineaId() {
        return componenteventasenlineaId;
    }

    public void setComponenteVentasEnLineaId(Long componenteventasenlineaId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
    }

    public Long getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Long promocionId) {
        this.promocionId = promocionId;
    }

    public PromocionEntity getPromocionEntity() {
        return promocionEntity;
    }

    public void setPromocionEntity(PromocionEntity promocionEntity) {
        this.promocionEntity = promocionEntity;
    }

    public ComponenteVentasEnLineaEntity getComponenteVentasEnLineaEntity() {
        return componenteventasenlineaEntity;
    }

    public void setComponenteVentasEnLineaEntity(ComponenteVentasEnLineaEntity componenteventasenlineaEntity) {
        this.componenteventasenlineaEntity = componenteventasenlineaEntity;
    }

}
