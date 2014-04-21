
package co.edu.uniandes.csw.product.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.product.logic.dto.ProductDTO;
import co.edu.uniandes.csw.product.logic.api._IProductLogicService;

public abstract class _ProductMockLogicService implements _IProductLogicService {

	private Long id= new Long(1);
	protected List<ProductDTO> data=new ArrayList<ProductDTO>();

	public ProductDTO createProduct(ProductDTO product){
		id++;
		product.setId(id);
		return product;
    }

	public List<ProductDTO> getProducts(){
		return data; 
	}

	public ProductDTO getProduct(Long id){
		for(ProductDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deleteProduct(Long id){
	    ProductDTO delete=null;
		for(ProductDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateProduct(ProductDTO product){
	    ProductDTO delete=null;
		for(ProductDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(product);
		} 
	}	
}