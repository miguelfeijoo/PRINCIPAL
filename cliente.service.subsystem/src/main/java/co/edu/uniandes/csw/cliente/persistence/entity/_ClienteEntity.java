
package co.edu.uniandes.csw.cliente.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _ClienteEntity {

	@Id
	@GeneratedValue(generator = "Cliente")
	private Long id;
	private String nombre;
	private String documento;
	private String name;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getDocumento(){
		return documento;
	}
	
	public void setDocumento(String documento){
		this.documento = documento;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}