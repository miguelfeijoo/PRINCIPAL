package co.edu.uniandes.csw.itemfactura.service;

import co.edu.uniandes.csw.itemfactura.logic.dto.ItemFacturaDTO;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ItemFactura")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemFacturaService extends _ItemFacturaService {

    @PUT
    @Path("/{idProducto}/{numeroUnidades}/agregarAlCarrito")
    public void agregarAlCarrito(@PathParam("idProducto") Long idProducto, @PathParam("numeroUnidades") int numUnidades)
    {
        ItemFacturaDTO item = new ItemFacturaDTO();
        item.setCantidad(numUnidades);
        item.setProductoId(idProducto);
        
        itemFacturaLogicService.createItemFactura(item);
    }
}