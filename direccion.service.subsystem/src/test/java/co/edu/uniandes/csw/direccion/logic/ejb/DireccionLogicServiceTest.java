
package co.edu.uniandes.csw.direccion.logic.ejb;

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
import co.edu.uniandes.csw.direccion.logic.api.IDireccionLogicService;
import co.edu.uniandes.csw.direccion.persistence.DireccionPersistence;
import co.edu.uniandes.csw.direccion.persistence.api.IDireccionPersistence;
import co.edu.uniandes.csw.direccion.persistence.entity.DireccionEntity;

@RunWith(Arquillian.class)
public class DireccionLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(DireccionLogicService.class.getPackage())
				.addPackage(DireccionPersistence.class.getPackage())
				.addPackage(DireccionEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IDireccionLogicService direccionLogicService;
	
	@Inject
	private IDireccionPersistence direccionPersistence;	

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
		List<DireccionDTO> dtos=direccionPersistence.getDireccions();
		for(DireccionDTO dto:dtos){
			direccionPersistence.deleteDireccion(dto.getId());
		}
	}

	private List<DireccionDTO> data=new ArrayList<DireccionDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			DireccionDTO pdto=new DireccionDTO();
			pdto.setDireccion(generateRandom(String.class));
			pdto.setName(generateRandom(String.class));
			pdto=direccionPersistence.createDireccion(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createDireccionTest(){
		DireccionDTO ldto=new DireccionDTO();
		ldto.setDireccion(generateRandom(String.class));
		ldto.setName(generateRandom(String.class));
		
		
		DireccionDTO result=direccionLogicService.createDireccion(ldto);
		
		Assert.assertNotNull(result);
		
		DireccionDTO pdto=direccionPersistence.getDireccion(result.getId());
		
		Assert.assertEquals(ldto.getDireccion(), pdto.getDireccion());	
		Assert.assertEquals(ldto.getName(), pdto.getName());	
	}
	
	@Test
	public void getDireccionsTest(){
		List<DireccionDTO> list=direccionLogicService.getDireccions();
		Assert.assertEquals(list.size(), data.size());
        for(DireccionDTO ldto:list){
        	boolean found=false;
            for(DireccionDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getDireccionTest(){
		DireccionDTO pdto=data.get(0);
		DireccionDTO ldto=direccionLogicService.getDireccion(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getDireccion(), ldto.getDireccion());
		Assert.assertEquals(pdto.getName(), ldto.getName());
        
	}
	
	@Test
	public void deleteDireccionTest(){
		DireccionDTO pdto=data.get(0);
		direccionLogicService.deleteDireccion(pdto.getId());
        DireccionDTO deleted=direccionPersistence.getDireccion(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateDireccionTest(){
		DireccionDTO pdto=data.get(0);
		
		DireccionDTO ldto=new DireccionDTO();
		ldto.setId(pdto.getId());
		ldto.setDireccion(generateRandom(String.class));
		ldto.setName(generateRandom(String.class));
		
		
		direccionLogicService.updateDireccion(ldto);
		
		
		DireccionDTO resp=direccionPersistence.getDireccion(pdto.getId());
		
		Assert.assertEquals(ldto.getDireccion(), resp.getDireccion());	
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