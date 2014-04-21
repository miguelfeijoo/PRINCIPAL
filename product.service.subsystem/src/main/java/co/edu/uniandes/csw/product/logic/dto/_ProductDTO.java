
package co.edu.uniandes.csw.product.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _ProductDTO {

	private Long id;
	private String name;
	private String description;
	private String image;
	private Long price;

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
	public String getDescription() {
		return description;
	}
 
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
 
	public void setImage(String image) {
		this.image = image;
	}
	public Long getPrice() {
		return price;
	}
 
	public void setPrice(Long price) {
		this.price = price;
	}
	
}