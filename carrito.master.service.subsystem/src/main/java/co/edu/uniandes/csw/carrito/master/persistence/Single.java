/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.carrito.master.persistence;

import co.edu.uniandes.csw.item.logic.dto.ItemDTO;
import co.edu.uniandes.csw.producto.logic.dto.ProductoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Single {
    
    public List<ItemDTO> items = new ArrayList<ItemDTO>();
    
    public List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
    
    public static Single i;
    
    public ProductoDTO getProducto(Long id)
    {
        for (ProductoDTO productoDTO : productos) 
        {
            if (productoDTO.getId() == id) return productoDTO;
        }
        return null;
    }
            
    private Single() 
    {
    }
    
    public static Single i() 
    {
        if (i == null) deSer();
        else ser();
        return i;
    }
}
