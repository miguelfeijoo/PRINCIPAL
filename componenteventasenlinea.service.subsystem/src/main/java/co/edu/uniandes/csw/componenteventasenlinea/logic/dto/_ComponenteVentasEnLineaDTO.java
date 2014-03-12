
package co.edu.uniandes.csw.componenteventasenlinea.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _ComponenteVentasEnLineaDTO {

	private Long id;
	private String name;
	private Long productoId;

	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	public Long getProductoId() {
		return productoId;
	}
 
	public void setProductoId(Long productoid) {
		this.productoId = productoid;
	}
	
}