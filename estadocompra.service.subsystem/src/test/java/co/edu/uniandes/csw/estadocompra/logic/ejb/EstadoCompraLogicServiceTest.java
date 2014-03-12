
package co.edu.uniandes.csw.estadocompra.logic.ejb;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;


import co.edu.uniandes.csw.estadocompra.logic.dto.EstadoCompraDTO;
import co.edu.uniandes.csw.estadocompra.logic.api.IEstadoCompraLogicService;
import co.edu.uniandes.csw.estadocompra.persistence.EstadoCompraPersistence;
import co.edu.uniandes.csw.estadocompra.persistence.api.IEstadoCompraPersistence;
import co.edu.uniandes.csw.estadocompra.persistence.entity.EstadoCompraEntity;

@RunWith(Arquillian.class)
public class EstadoCompraLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(EstadoCompraLogicService.class.getPackage())
				.addPackage(EstadoCompraPersistence.class.getPackage())
				.addPackage(EstadoCompraEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IEstadoCompraLogicService estadoCompraLogicService;
	
	@Inject
	private IEstadoCompraPersistence estadoCompraPersistence;	

	@Before
	public void configTest() {
		try {
			clearData();
			insertData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clearData() {
		List<EstadoCompraDTO> dtos=estadoCompraPersistence.getEstadoCompras();
		for(EstadoCompraDTO dto:dtos){
			estadoCompraPersistence.deleteEstadoCompra(dto.getId());
		}
	}

	private List<EstadoCompraDTO> data=new ArrayList<EstadoCompraDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			EstadoCompraDTO pdto=new EstadoCompraDTO();
			pdto.setName(generateRandom(String.class));
			pdto=estadoCompraPersistence.createEstadoCompra(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createEstadoCompraTest(){
		EstadoCompraDTO ldto=new EstadoCompraDTO();
		ldto.setName(generateRandom(String.class));
		
		
		EstadoCompraDTO result=estadoCompraLogicService.createEstadoCompra(ldto);
		
		Assert.assertNotNull(result);
		
		EstadoCompraDTO pdto=estadoCompraPersistence.getEstadoCompra(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
	}
	
	@Test
	public void getEstadoComprasTest(){
		List<EstadoCompraDTO> list=estadoCompraLogicService.getEstadoCompras();
		Assert.assertEquals(list.size(), data.size());
        for(EstadoCompraDTO ldto:list){
        	boolean found=false;
            for(EstadoCompraDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getEstadoCompraTest(){
		EstadoCompraDTO pdto=data.get(0);
		EstadoCompraDTO ldto=estadoCompraLogicService.getEstadoCompra(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
        
	}
	
	@Test
	public void deleteEstadoCompraTest(){
		EstadoCompraDTO pdto=data.get(0);
		estadoCompraLogicService.deleteEstadoCompra(pdto.getId());
        EstadoCompraDTO deleted=estadoCompraPersistence.getEstadoCompra(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateEstadoCompraTest(){
		EstadoCompraDTO pdto=data.get(0);
		
		EstadoCompraDTO ldto=new EstadoCompraDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		
		
		estadoCompraLogicService.updateEstadoCompra(ldto);
		
		
		EstadoCompraDTO resp=estadoCompraPersistence.getEstadoCompra(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
	}
	
	public <T> T generateRandom(Class<T> objectClass){
		Random r=new Random();
		if(objectClass.isInstance(String.class)){
			String s="";
			for(int i=0;i<10;i++){
				char c=(char)(r.nextInt()/('Z'-'A')+'A');
				s=s+c;
			}
			return objectClass.cast(s);
		}else if(objectClass.isInstance(Integer.class)){
			Integer s=r.nextInt();
			return objectClass.cast(s);
		}else if(objectClass.isInstance(Long.class)){
			Long s=r.nextLong();
			return objectClass.cast(s);
		}else if(objectClass.isInstance(java.util.Date.class)){
			java.util.Calendar c=java.util.Calendar.getInstance();
			c.set(java.util.Calendar.MONTH, r.nextInt()/12);
			c.set(java.util.Calendar.DAY_OF_MONTH,r.nextInt()/30);
			c.setLenient(false);
			return objectClass.cast(c.getTime());
		} 
		return null;
	}
	
}