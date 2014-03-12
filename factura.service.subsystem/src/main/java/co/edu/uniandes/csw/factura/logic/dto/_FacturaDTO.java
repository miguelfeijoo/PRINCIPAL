
package co.edu.uniandes.csw.factura.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _FacturaDTO {

	private Long id;
	private Integer numeroFactura;
	private String name;

	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumeroFactura() {
		return numeroFactura;
	}
 
	public void setNumeroFactura(Integer numerofactura) {
		this.numeroFactura = numerofactura;
	}
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
}