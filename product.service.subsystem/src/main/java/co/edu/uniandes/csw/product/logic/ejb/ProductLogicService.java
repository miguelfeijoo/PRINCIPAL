
package co.edu.uniandes.csw.product.logic.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import co.edu.uniandes.csw.product.logic.api.IProductLogicService;
import co.edu.uniandes.csw.product.logic.dto.ProductDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.product.logic.api.IProductLogicService;
import co.edu.uniandes.csw.product.logic.dto.ProductDTO;

@Default
@Stateless
@LocalBean
public class ProductLogicService extends _ProductLogicService implements IProductLogicService 
{
    //URL donde se encuentra los servicios de lso proveedores (cambia según el archivo service.properties)
 
    public static String URL_SERVICIO = "http://localhost:8080/producto.service.subsystem.web";
    /**
     * Esta anotación indica que este método se debe ejecutar cuando se
     * instancia este bean de sesión Se encarga de cargar el archivo de
     * properties con el URL de la aplicación de proveedores ubicado en
     * (directorio instalación
     * glassfish)/glassfishv3/glassfish/domains/domain1/config
     */
    @PostConstruct
    public void initService() {
        Properties prop = new Properties();
        OutputStream output = null;
        //Lee del archivo de propiedades de glassfish/domains/domain1/config
        try {
            File file = new File("services.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            URL_SERVICIO = properties.getProperty("url");
        } catch (Exception e) {
            //Sin no existe lo crea por defecto
            try {
                output = new FileOutputStream("services.properties");
                prop.setProperty("url", URL_SERVICIO);
                prop.store(output, null);
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
 
        }
    }
    /**
     * Se reimplementa el método 'getProduct' para que consulte en el servicio
     * remoto en vez de la persistencia.
     * @param id
     * @return 
     */
    @Override
    public ProductDTO getProduct(Long id) {
        try {
            //Se crea un cliente apache
            Client client = Client.create();
            /**
             * SE CONSUME EL SERVICIO REMOTO DE PRODUCTOS getProducto.
             * URL_SERVICIO tiene la ubicación de la aplicación de proveedores
             * (que se carga de service.properties)
             */
            WebResource webResource = client.resource(URL_SERVICIO + "/webresources/Producto/" + id);
            // Se instancia un nuevo object mapper para convertir el string JSON a un DTO
            ObjectMapper map = new ObjectMapper();
            //Se obtiene el string JSON por medio de get
            String resp = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(String.class);
            //Se convierte el String a un DTO con ayuda de jackson y luego se retorna
            ProductDTO dto = map.readValue(resp, ProductDTO.class);
            return dto;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * Se reimplementa el método 'getProducts' de _productLogicService para que
     * consulte la lista de productos en el servicio de la otra aplicación.
     * @return 
     */
    @Override
    public List<ProductDTO> getProducts() {
        try {
            Client client = Client.create();
            //SE CONSUME EL SERVICIO REMOTO DE PRODUCTOS getProductos
            WebResource webResource = client.resource(URL_SERVICIO + "/webresources/Producto");
            // Se instancia un nuevo object mapper para convertir el string JSON a un DTO
            ObjectMapper map = new ObjectMapper();
            //Se convierte el String a un DTO y luego se retorna
            String resp = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(String.class);
            //Se convierte a una lista de DTO con ayuda de jackson y se retrona.
            List<ProductDTO> dto = map.readValue(resp, TypeFactory.defaultInstance().constructCollectionType(List.class, ProductDTO.class));
            return dto;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}