
package co.edu.uniandes.csw.factura.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _FacturaEntity {

	@Id
	@GeneratedValue(generator = "Factura")
	private Long id;
	private Integer numeroFactura;
	private String name;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public Integer getNumeroFactura(){
		return numeroFactura;
	}
	
	public void setNumeroFactura(Integer numeroFactura){
		this.numeroFactura = numeroFactura;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}