package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class ComponenteVentasEnLineaPromocionEntityId implements Serializable{

    private Long componenteventasenlineaId;
    private Long promocionId;

    @Override
    public int hashCode() {
        return (int) (componenteventasenlineaId + promocionId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ComponenteVentasEnLineaPromocionEntityId) {
            ComponenteVentasEnLineaPromocionEntityId otherId = (ComponenteVentasEnLineaPromocionEntityId) object;
            return (otherId.componenteventasenlineaId == this.componenteventasenlineaId) && (otherId.promocionId == this.promocionId);
        }
        return false;
    }

}
