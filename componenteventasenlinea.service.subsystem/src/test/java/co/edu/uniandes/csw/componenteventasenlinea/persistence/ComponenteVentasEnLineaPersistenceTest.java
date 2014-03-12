
package co.edu.uniandes.csw.componenteventasenlinea.persistence;

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
import co.edu.uniandes.csw.componenteventasenlinea.persistence.api.IComponenteVentasEnLineaPersistence;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.entity.ComponenteVentasEnLineaEntity;

@RunWith(Arquillian.class)
public class ComponenteVentasEnLineaPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(ComponenteVentasEnLineaPersistence.class.getPackage())
				.addPackage(ComponenteVentasEnLineaEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IComponenteVentasEnLineaPersistence componenteVentasEnLineaPersistence;

	@PersistenceContext
	private EntityManager em;

	@Inject
	UserTransaction utx;

	@Before
	public void configTest() {
		System.out.println("em: " + em);
		try {
			utx.begin();
			clearData();
			insertData();
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				utx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void clearData() {
		em.createQuery("delete from ComponenteVentasEnLineaEntity").executeUpdate();
	}

	private List<ComponenteVentasEnLineaEntity> data=new ArrayList<ComponenteVentasEnLineaEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			ComponenteVentasEnLineaEntity entity=new ComponenteVentasEnLineaEntity();
			entity.setName(generateRandom(String.class));
			entity.setProductoId(generateRandom(Long.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaDTO dto=new ComponenteVentasEnLineaDTO();
		dto.setName(generateRandom(String.class));
		dto.setProductoId(generateRandom(Long.class));
		
		
		ComponenteVentasEnLineaDTO result=componenteVentasEnLineaPersistence.createComponenteVentasEnLinea(dto);
		
		Assert.assertNotNull(result);
		
		ComponenteVentasEnLineaEntity entity=em.find(ComponenteVentasEnLineaEntity.class, result.getId());
		
		Assert.assertEquals(dto.getName(), entity.getName());	
		Assert.assertEquals(dto.getProductoId(), entity.getProductoId());	
	}
	
	@Test
	public void getComponenteVentasEnLineasTest(){
		List<ComponenteVentasEnLineaDTO> list=componenteVentasEnLineaPersistence.getComponenteVentasEnLineas();
		Assert.assertEquals(list.size(), data.size());
        for(ComponenteVentasEnLineaDTO dto:list){
        	boolean found=false;
            for(ComponenteVentasEnLineaEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaEntity entity=data.get(0);
		ComponenteVentasEnLineaDTO dto=componenteVentasEnLineaPersistence.getComponenteVentasEnLinea(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getName(), dto.getName());
		Assert.assertEquals(entity.getProductoId(), dto.getProductoId());
        
	}
	
	@Test
	public void deleteComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaEntity entity=data.get(0);
		componenteVentasEnLineaPersistence.deleteComponenteVentasEnLinea(entity.getId());
        ComponenteVentasEnLineaEntity deleted=em.find(ComponenteVentasEnLineaEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateComponenteVentasEnLineaTest(){
		ComponenteVentasEnLineaEntity entity=data.get(0);
		
		ComponenteVentasEnLineaDTO dto=new ComponenteVentasEnLineaDTO();
		dto.setId(entity.getId());
		dto.setName(generateRandom(String.class));
		dto.setProductoId(generateRandom(Long.class));
		
		
		componenteVentasEnLineaPersistence.updateComponenteVentasEnLinea(dto);
		
		
		ComponenteVentasEnLineaEntity resp=em.find(ComponenteVentasEnLineaEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getName(), resp.getName());	
		Assert.assertEquals(dto.getProductoId(), resp.getProductoId());	
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