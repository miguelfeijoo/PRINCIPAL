package co.edu.uniandes.csw.carrito.master.persistence;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.carrito.master.persistence.entity.CarritoItemEntity;
import co.edu.uniandes.csw.item.persistence.converter.ItemConverter;
import co.edu.uniandes.csw.carrito.logic.dto.CarritoDTO;
import co.edu.uniandes.csw.carrito.master.logic.dto.CarritoMasterDTO;
import co.edu.uniandes.csw.carrito.master.persistence.api._ICarritoMasterPersistence;
import co.edu.uniandes.csw.carrito.persistence.api.ICarritoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _CarritoMasterPersistence implements _ICarritoMasterPersistence {

    @PersistenceContext(unitName = "CarritoMasterPU")
    protected EntityManager entityManager;
    
    @Inject
    protected ICarritoPersistence carritoPersistence;  

    public CarritoMasterDTO getCarrito(Long carritoId) {
        CarritoMasterDTO carritoMasterDTO = new CarritoMasterDTO();
        CarritoDTO carrito = carritoPersistence.getCarrito(carritoId);
        carritoMasterDTO.setCarritoEntity(carrito);
        carritoMasterDTO.setListItem(getItemListForCarrito(carritoId));
        return carritoMasterDTO;
    }

    public CarritoItemEntity createCarritoItem(CarritoItemEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteCarritoItem(Long carritoId, Long itemId) {
        Query q = entityManager.createNamedQuery("CarritoItemEntity.deleteCarritoItem");
        q.setParameter("carritoId", carritoId);
        q.setParameter("itemId", itemId);
        q.executeUpdate();
    }

    public List<ItemDTO> getItemListForCarrito(Long carritoId) {
        ArrayList<ItemDTO> resp = new ArrayList<ItemDTO>();
        Query q = entityManager.createNamedQuery("CarritoItemEntity.getItemListForCarrito");
        q.setParameter("carritoId", carritoId);
        List<CarritoItemEntity> qResult =  q.getResultList();
        for (CarritoItemEntity carritoItemEntity : qResult) { 
            if(carritoItemEntity.getItemEntity()==null){
                entityManager.refresh(carritoItemEntity);
            }
            resp.add(ItemConverter.entity2PersistenceDTO(carritoItemEntity.getItemEntity()));
        }
        return resp;
    }

}
