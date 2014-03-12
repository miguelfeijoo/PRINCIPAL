package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class ComponenteVentasEnLineaClienteEntityId implements Serializable{

    private Long componenteventasenlineaId;
    private Long clienteId;

    @Override
    public int hashCode() {
        return (int) (componenteventasenlineaId + clienteId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ComponenteVentasEnLineaClienteEntityId) {
            ComponenteVentasEnLineaClienteEntityId otherId = (ComponenteVentasEnLineaClienteEntityId) object;
            return (otherId.componenteventasenlineaId == this.componenteventasenlineaId) && (otherId.clienteId == this.clienteId);
        }
        return false;
    }

}
