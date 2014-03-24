package co.edu.uniandes.csw.carrito.master.logic.ejb;

import co.edu.uniandes.csw.carrito.master.logic.api.ICarritoMasterLogicService;
import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Default
@Stateless
@LocalBean
public class CarritoMasterLogicService extends _CarritoMasterLogicService implements ICarritoMasterLogicService 
{
    @PUT
    @Path("{id}/comprarcarrito")
    public void comprarCarrito(Long id) 
    {
        double costo = calcularCostoCarrito(id);
        
        System.out.println("!!!");
    }
        
    private double calcularCostoCarrito (Long id)
    {
        List<ItemDTO> itemsCarrito = carritoMasterPersistance.getItemListForCarrito(id);
        
        double costo = 0;
        
        for(ItemDTO item: itemsCarrito)
        {
            costo += 0; //OBTENER PRECIO DE LOS PRODUCTOS
        }
        
        costo += costo*0.16;
        
        return costo;
    }

    public void finalizarCompra(Long id) 
    {
        
    }
}