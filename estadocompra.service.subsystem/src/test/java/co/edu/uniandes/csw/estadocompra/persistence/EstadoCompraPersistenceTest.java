
package co.edu.uniandes.csw.estadocompra.persistence;

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
import co.edu.uniandes.csw.estadocompra.persistence.api.IEstadoCompraPersistence;
import co.edu.uniandes.csw.estadocompra.persistence.entity.EstadoCompraEntity;

@RunWith(Arquillian.class)
public class EstadoCompraPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(EstadoCompraPersistence.class.getPackage())
				.addPackage(EstadoCompraEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IEstadoCompraPersistence estadoCompraPersistence;

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
		em.createQuery("delete from EstadoCompraEntity").executeUpdate();
	}

	private List<EstadoCompraEntity> data=new ArrayList<EstadoCompraEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			EstadoCompraEntity entity=new EstadoCompraEntity();
			entity.setName(generateRandom(String.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createEstadoCompraTest(){
		EstadoCompraDTO dto=new EstadoCompraDTO();
		dto.setName(generateRandom(String.class));
		
		
		EstadoCompraDTO result=estadoCompraPersistence.createEstadoCompra(dto);
		
		Assert.assertNotNull(result);
		
		EstadoCompraEntity entity=em.find(EstadoCompraEntity.class, result.getId());
		
		Assert.assertEquals(dto.getName(), entity.getName());	
	}
	
	@Test
	public void getEstadoComprasTest(){
		List<EstadoCompraDTO> list=estadoCompraPersistence.getEstadoCompras();
		Assert.assertEquals(list.size(), data.size());
        for(EstadoCompraDTO dto:list){
        	boolean found=false;
            for(EstadoCompraEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getEstadoCompraTest(){
		EstadoCompraEntity entity=data.get(0);
		EstadoCompraDTO dto=estadoCompraPersistence.getEstadoCompra(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getName(), dto.getName());
        
	}
	
	@Test
	public void deleteEstadoCompraTest(){
		EstadoCompraEntity entity=data.get(0);
		estadoCompraPersistence.deleteEstadoCompra(entity.getId());
        EstadoCompraEntity deleted=em.find(EstadoCompraEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateEstadoCompraTest(){
		EstadoCompraEntity entity=data.get(0);
		
		EstadoCompraDTO dto=new EstadoCompraDTO();
		dto.setId(entity.getId());
		dto.setName(generateRandom(String.class));
		
		
		estadoCompraPersistence.updateEstadoCompra(dto);
		
		
		EstadoCompraEntity resp=em.find(EstadoCompraEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getName(), resp.getName());	
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