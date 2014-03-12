
package co.edu.uniandes.csw.componenteventasenlinea.logic.ejb;

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


import co.edu.uniandes.csw.componenteventasenlinea.logic.dto.ComponenteVentasEnLineaDTO;
import co.edu.uniandes.csw.componenteventasenlinea.logic.api.IComponenteVentasEnLineaLogicService;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.ComponenteVentasEnLineaPersistence;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.api.IComponenteVentasEnLineaPersistence;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.entity.ComponenteVentasEnLineaEntity;

@RunWith(Arquillian.class)
public class ComponenteVentasEnLineaLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(ComponenteVentasEnLineaLogicService.class.getPackage())
				.addPackage(ComponenteVentasEnLineaPersistence.class.getPackage())
				.addPackage(ComponenteVentasEnLineaEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IComponenteVentasEnLineaLogicService componenteVentasEnLineaLogicService;
	
	@Inject
	private IComponenteVentasEnLineaPersistence componenteVentasEnLineaPersistence;	

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
		List<ComponenteVentasEnLineaDTO> dtos=componenteVentasEnLineaPersistence.getComponenteVentasEnLineas();
		for(ComponenteVentasEnLineaDTO dto:dtos){
			componenteVentasEnLineaPersistence.deleteComponenteVentasEnLinea(dto.getId());
		}
	}

	private List<ComponenteVentasEnLineaDTO> data=new ArrayList<ComponenteVentasEnLineaDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			ComponenteVentasEnLineaDTO pdto=new ComponenteVentasEnLineaDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setProductoId(generateRandom(Long.class));
			pdto=componenteVentasEnLineaPersistence.createComponenteVentasEnLinea(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaDTO ldto=new ComponenteVentasEnLineaDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setProductoId(generateRandom(Long.class));
		
		
		ComponenteVentasEnLineaDTO result=componenteVentasEnLineaLogicService.createComponenteVentasEnLinea(ldto);
		
		Assert.assertNotNull(result);
		
		ComponenteVentasEnLineaDTO pdto=componenteVentasEnLineaPersistence.getComponenteVentasEnLinea(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getProductoId(), pdto.getProductoId());	
	}
	
	@Test
	public void getComponenteVentasEnLineasTest(){
		List<ComponenteVentasEnLineaDTO> list=componenteVentasEnLineaLogicService.getComponenteVentasEnLineas();
		Assert.assertEquals(list.size(), data.size());
        for(ComponenteVentasEnLineaDTO ldto:list){
        	boolean found=false;
            for(ComponenteVentasEnLineaDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaDTO pdto=data.get(0);
		ComponenteVentasEnLineaDTO ldto=componenteVentasEnLineaLogicService.getComponenteVentasEnLinea(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getProductoId(), ldto.getProductoId());
        
	}
	
	@Test
	public void deleteComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaDTO pdto=data.get(0);
		componenteVentasEnLineaLogicService.deleteComponenteVentasEnLinea(pdto.getId());
        ComponenteVentasEnLineaDTO deleted=componenteVentasEnLineaPersistence.getComponenteVentasEnLinea(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaDTO pdto=data.get(0);
		
		ComponenteVentasEnLineaDTO ldto=new ComponenteVentasEnLineaDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setProductoId(generateRandom(Long.class));
		
		
		componenteVentasEnLineaLogicService.updateComponenteVentasEnLinea(ldto);
		
		
		ComponenteVentasEnLineaDTO resp=componenteVentasEnLineaPersistence.getComponenteVentasEnLinea(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getProductoId(), resp.getProductoId());	
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