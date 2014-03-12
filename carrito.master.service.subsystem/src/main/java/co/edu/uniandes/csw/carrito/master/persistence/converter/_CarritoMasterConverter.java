package co.edu.uniandes.csw.carrito.master.persistence.converter;
import co.edu.uniandes.csw.carrito.master.persistence.entity.CarritoItemEntity;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.item.persistence.converter.ItemConverter;
import co.edu.uniandes.csw.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.csw.carrito.master.logic.dto.CarritoMasterDTO;
import co.edu.uniandes.csw.carrito.persistence.converter.CarritoConverter;
import co.edu.uniandes.csw.carrito.persistence.entity.CarritoEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _CarritoMasterConverter {

    public static CarritoMasterDTO entity2PersistenceDTO(CarritoEntity carritoEntity 
    ,List<CarritoItemEntity> carritoItemEntity 
    ) {
        CarritoDTO carritoDTO = CarritoConverter.entity2PersistenceDTO(carritoEntity);
        ArrayList<ItemDTO> itemEntities = new ArrayList<ItemDTO>(carritoItemEntity.size());
        for (CarritoItemEntity carritoItem : carritoItemEntity) {
            itemEntities.add(ItemConverter.entity2PersistenceDTO(carritoItem.getItemEntity()));
        }
        CarritoMasterDTO respDTO  = new CarritoMasterDTO();
        respDTO.setCarritoEntity(carritoDTO);
        respDTO.setListItem(itemEntities);
        return respDTO;
    }

}