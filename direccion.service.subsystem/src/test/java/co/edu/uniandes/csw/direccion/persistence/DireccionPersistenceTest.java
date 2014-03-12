
package co.edu.uniandes.csw.direccion.persistence;

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


import co.edu.uniandes.csw.direccion.logic.dto.DireccionDTO;
import co.edu.uniandes.csw.direccion.persistence.api.IDireccionPersistence;
import co.edu.uniandes.csw.direccion.persistence.entity.DireccionEntity;

@RunWith(Arquillian.class)
public class DireccionPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(DireccionPersistence.class.getPackage())
				.addPackage(DireccionEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IDireccionPersistence direccionPersistence;

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
		em.createQuery("delete from DireccionEntity").executeUpdate();
	}

	private List<DireccionEntity> data=new ArrayList<DireccionEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			DireccionEntity entity=new DireccionEntity();
			entity.setDireccion(generateRandom(String.class));
			entity.setName(generateRandom(String.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createDireccionTest(){
		DireccionDTO dto=new DireccionDTO();
		dto.setDireccion(generateRandom(String.class));
		dto.setName(generateRandom(String.class));
		
		
		DireccionDTO result=direccionPersistence.createDireccion(dto);
		
		Assert.assertNotNull(result);
		
		DireccionEntity entity=em.find(DireccionEntity.class, result.getId());
		
		Assert.assertEquals(dto.getDireccion(), entity.getDireccion());	
		Assert.assertEquals(dto.getName(), entity.getName());	
	}
	
	@Test
	public void getDireccionsTest(){
		List<DireccionDTO> list=direccionPersistence.getDireccions();
		Assert.assertEquals(list.size(), data.size());
        for(DireccionDTO dto:list){
        	boolean found=false;
            for(DireccionEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getDireccionTest(){
		DireccionEntity entity=data.get(0);
		DireccionDTO dto=direccionPersistence.getDireccion(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getDireccion(), dto.getDireccion());
		Assert.assertEquals(entity.getName(), dto.getName());
        
	}
	
	@Test
	public void deleteDireccionTest(){
		DireccionEntity entity=data.get(0);
		direccionPersistence.deleteDireccion(entity.getId());
        DireccionEntity deleted=em.find(DireccionEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateDireccionTest(){
		DireccionEntity entity=data.get(0);
		
		DireccionDTO dto=new DireccionDTO();
		dto.setId(entity.getId());
		dto.setDireccion(generateRandom(String.class));
		dto.setName(generateRandom(String.class));
		
		
		direccionPersistence.updateDireccion(dto);
		
		
		DireccionEntity resp=em.find(DireccionEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getDireccion(), resp.getDireccion());	
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