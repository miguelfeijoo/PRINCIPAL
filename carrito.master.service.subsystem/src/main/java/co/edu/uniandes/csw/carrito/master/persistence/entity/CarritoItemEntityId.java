package co.edu.uniandes.csw.carrito.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class CarritoItemEntityId implements Serializable{

    private Long carritoId;
    private Long itemId;

    @Override
    public int hashCode() {
        return (int) (carritoId + itemId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof CarritoItemEntityId) {
            CarritoItemEntityId otherId = (CarritoItemEntityId) object;
            return (otherId.carritoId == this.carritoId) && (otherId.itemId == this.itemId);
        }
        return false;
    }

}
