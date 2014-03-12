package co.edu.uniandes.csw.carrito.master.logic.ejb;

import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.persistence.api.IItemPersistence;
import co.edu.uniandes.csw.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.csw.carrito.master.logic.api._ICarritoMasterLogicService;
import co.edu.uniandes.csw.carrito.master.logic.dto.CarritoMasterDTO;
import co.edu.uniandes.csw.carrito.master.persistence.api.ICarritoMasterPersistence;
import co.edu.uniandes.csw.carrito.master.persistence.entity.CarritoItemEntity;
import co.edu.uniandes.csw.carrito.persistence.api.ICarritoPersistence;
import javax.inject.Inject;

public abstract class _CarritoMasterLogicService implements _ICarritoMasterLogicService {

    @Inject
    protected ICarritoPersistence carritoPersistance;
    @Inject
    protected ICarritoMasterPersistence carritoMasterPersistance;
    @Inject
    protected IItemPersistence itemPersistance;

    public CarritoMasterDTO createMasterCarrito(CarritoMasterDTO carrito) {
        CarritoDTO persistedCarritoDTO = carritoPersistance.createCarrito(carrito.getCarritoEntity());
        if (carrito.getCreateItem() != null) {
            for (ItemDTO itemDTO : carrito.getCreateItem()) {
                ItemDTO persistedItemDTO = itemPersistance.createItem(itemDTO);
                CarritoItemEntity carritoItemEntity = new CarritoItemEntity(persistedCarritoDTO.getId(), persistedItemDTO.getId());
                carritoMasterPersistance.createCarritoItem(carritoItemEntity);
            }
        }
        return carrito;
    }

    public CarritoMasterDTO getMasterCarrito(Long id) {
        return carritoMasterPersistance.getCarrito(id);
    }

    public void deleteMasterCarrito(Long id) {
        carritoPersistance.deleteCarrito(id);
    }

    public void updateMasterCarrito(CarritoMasterDTO carrito) {
        carritoPersistance.updateCarrito(carrito.getCarritoEntity());

        //---- FOR RELATIONSHIP
        // persist new item
        if (carrito.getCreateItem() != null) {
            for (ItemDTO itemDTO : carrito.getCreateItem()) {
                ItemDTO persistedItemDTO = itemPersistance.createItem(itemDTO);
                CarritoItemEntity carritoItemEntity = new CarritoItemEntity(carrito.getCarritoEntity().getId(), persistedItemDTO.getId());
                carritoMasterPersistance.createCarritoItem(carritoItemEntity);
            }
        }
        // update item
        if (carrito.getUpdateItem() != null) {
            for (ItemDTO itemDTO : carrito.getUpdateItem()) {
                itemPersistance.updateItem(itemDTO);
            }
        }
        // delete item
        if (carrito.getDeleteItem() != null) {
            for (ItemDTO itemDTO : carrito.getDeleteItem()) {
                carritoMasterPersistance.deleteCarritoItem(carrito.getCarritoEntity().getId(), itemDTO.getId());
                itemPersistance.deleteItem(itemDTO.getId());
            }
        }
    }
}
