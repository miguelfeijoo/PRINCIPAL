package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class ComponenteVentasEnLineaFacturaEntityId implements Serializable{

    private Long componenteventasenlineaId;
    private Long facturaId;

    @Override
    public int hashCode() {
        return (int) (componenteventasenlineaId + facturaId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ComponenteVentasEnLineaFacturaEntityId) {
            ComponenteVentasEnLineaFacturaEntityId otherId = (ComponenteVentasEnLineaFacturaEntityId) object;
            return (otherId.componenteventasenlineaId == this.componenteventasenlineaId) && (otherId.facturaId == this.facturaId);
        }
        return false;
    }

}
