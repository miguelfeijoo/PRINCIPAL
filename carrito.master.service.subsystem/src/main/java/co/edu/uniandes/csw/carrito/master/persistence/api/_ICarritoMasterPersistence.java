package co.edu.uniandes.csw.carrito.master.persistence.api;

import co.edu.uniandes.csw.carrito.master.persistence.entity.CarritoItemEntity;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.carrito.master.logic.dto.CarritoMasterDTO;
import java.util.List;

public interface _ICarritoMasterPersistence {

    public CarritoItemEntity createCarritoItem(CarritoItemEntity entity);

    public void deleteCarritoItem(Long carritoId, Long itemId);
    
    public List<ItemDTO> getItemListForCarrito(Long carritoId);
    
    public CarritoMasterDTO getCarrito(Long carritoId);

}
