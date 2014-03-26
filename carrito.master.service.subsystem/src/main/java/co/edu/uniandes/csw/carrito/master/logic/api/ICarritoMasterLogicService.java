 

package co.edu.uniandes.csw.carrito.master.logic.api;

public interface ICarritoMasterLogicService extends _ICarritoMasterLogicService 
{
    public boolean comprarCarrito(Long id);

    public void finalizarCompra(Long id);
}