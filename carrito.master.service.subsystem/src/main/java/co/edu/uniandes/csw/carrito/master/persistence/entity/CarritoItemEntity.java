package co.edu.uniandes.csw.carrito.master.persistence.entity;

import co.edu.uniandes.csw.item.persistence.entity.ItemEntity;
import co.edu.uniandes.csw.carrito.persistence.entity.CarritoEntity;
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
@IdClass(CarritoItemEntityId.class)
@NamedQueries({
    @NamedQuery(name = "CarritoItemEntity.getItemListForCarrito", query = "SELECT  u FROM CarritoItemEntity u WHERE u.carritoId=:carritoId"),
    @NamedQuery(name = "CarritoItemEntity.deleteCarritoItem", query = "DELETE FROM CarritoItemEntity u WHERE u.itemId=:itemId and  u.carritoId=:carritoId")
})
public class CarritoItemEntity implements Serializable {

    @Id
    @Column(name = "carritoId")
    private Long carritoId;
    @Id
    @Column(name = "itemId")
    private Long itemId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "itemId", referencedColumnName = "id")
    @JoinFetch
    private ItemEntity itemEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "carritoId", referencedColumnName = "id")
    @JoinFetch
    private CarritoEntity carritoEntity;

    public CarritoItemEntity() {
    }

    public CarritoItemEntity(Long carritoId, Long itemId) {
        this.carritoId = carritoId;
        this.itemId = itemId;
    }

    public Long getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Long carritoId) {
        this.carritoId = carritoId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    public CarritoEntity getCarritoEntity() {
        return carritoEntity;
    }

    public void setCarritoEntity(CarritoEntity carritoEntity) {
        this.carritoEntity = carritoEntity;
    }

}
