
package co.edu.uniandes.csw.cliente.persistence;

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


import co.edu.uniandes.csw.cliente.logic.dto.ClienteDTO;
import co.edu.uniandes.csw.cliente.persistence.api.IClientePersistence;
import co.edu.uniandes.csw.cliente.persistence.entity.ClienteEntity;

@RunWith(Arquillian.class)
public class ClientePersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(ClientePersistence.class.getPackage())
				.addPackage(ClienteEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private IClientePersistence clientePersistence;

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
		em.createQuery("delete from ClienteEntity").executeUpdate();
	}

	private List<ClienteEntity> data=new ArrayList<ClienteEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			ClienteEntity entity=new ClienteEntity();
			entity.setNombre(generateRandom(String.class));
			entity.setDocumento(generateRandom(String.class));
			entity.setName(generateRandom(String.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createClienteTest(){
		ClienteDTO dto=new ClienteDTO();
		dto.setNombre(generateRandom(String.class));
		dto.setDocumento(generateRandom(String.class));
		dto.setName(generateRandom(String.class));
		
		
		ClienteDTO result=clientePersistence.createCliente(dto);
		
		Assert.assertNotNull(result);
		
		ClienteEntity entity=em.find(ClienteEntity.class, result.getId());
		
		Assert.assertEquals(dto.getNombre(), entity.getNombre());	
		Assert.assertEquals(dto.getDocumento(), entity.getDocumento());	
		Assert.assertEquals(dto.getName(), entity.getName());	
	}
	
	@Test
	public void getClientesTest(){
		List<ClienteDTO> list=clientePersistence.getClientes();
		Assert.assertEquals(list.size(), data.size());
        for(ClienteDTO dto:list){
        	boolean found=false;
            for(ClienteEntity entity:data){
            	if(dto.getId()==entity.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getClienteTest(){
		ClienteEntity entity=data.get(0);
		ClienteDTO dto=clientePersistence.getCliente(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getNombre(), dto.getNombre());
		Assert.assertEquals(entity.getDocumento(), dto.getDocumento());
		Assert.assertEquals(entity.getName(), dto.getName());
        
	}
	
	@Test
	public void deleteClienteTest(){
		ClienteEntity entity=data.get(0);
		clientePersistence.deleteCliente(entity.getId());
        ClienteEntity deleted=em.find(ClienteEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateClienteTest(){
		ClienteEntity entity=data.get(0);
		
		ClienteDTO dto=new ClienteDTO();
		dto.setId(entity.getId());
		dto.setNombre(generateRandom(String.class));
		dto.setDocumento(generateRandom(String.class));
		dto.setName(generateRandom(String.class));
		
		
		clientePersistence.updateCliente(dto);
		
		
		ClienteEntity resp=em.find(ClienteEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getNombre(), resp.getNombre());	
		Assert.assertEquals(dto.getDocumento(), resp.getDocumento());	
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