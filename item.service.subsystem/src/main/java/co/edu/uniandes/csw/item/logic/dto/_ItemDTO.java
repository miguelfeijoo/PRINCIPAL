
package co.edu.uniandes.csw.item.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _ItemDTO {

	private Long id;
	private String name;
	private Integer cantidad;
	private Long productId;

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
	public Integer getCantidad() {
		return cantidad;
	}
 
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Long getProductId() {
		return productId;
	}
 
	public void setProductId(Long productid) {
		this.productId = productid;
	}
	
}