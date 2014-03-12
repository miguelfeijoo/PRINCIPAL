package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class ComponenteVentasEnLineaProductoEntityId implements Serializable{

    private Long componenteventasenlineaId;
    private Long productoId;

    @Override
    public int hashCode() {
        return (int) (componenteventasenlineaId + productoId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ComponenteVentasEnLineaProductoEntityId) {
            ComponenteVentasEnLineaProductoEntityId otherId = (ComponenteVentasEnLineaProductoEntityId) object;
            return (otherId.componenteventasenlineaId == this.componenteventasenlineaId) && (otherId.productoId == this.productoId);
        }
        return false;
    }

}
