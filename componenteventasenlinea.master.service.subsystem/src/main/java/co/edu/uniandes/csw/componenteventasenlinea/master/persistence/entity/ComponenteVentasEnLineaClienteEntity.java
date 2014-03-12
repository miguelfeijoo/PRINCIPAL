package co.edu.uniandes.csw.componenteventasenlinea.master.persistence.entity;

import co.edu.uniandes.csw.cliente.persistence.entity.ClienteEntity;
import co.edu.uniandes.csw.componenteventasenlinea.persistence.entity.ComponenteVentasEnLineaEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(ComponenteVentasEnLineaClienteEntityId.class)
@NamedQueries({
    @NamedQuery(name = "ComponenteVentasEnLineaClienteEntity.getClienteListForComponenteVentasEnLinea", query = "SELECT  u FROM ComponenteVentasEnLineaClienteEntity u WHERE u.componenteventasenlineaId=:componenteventasenlineaId"),
    @NamedQuery(name = "ComponenteVentasEnLineaClienteEntity.deleteComponenteVentasEnLineaCliente", query = "DELETE FROM ComponenteVentasEnLineaClienteEntity u WHERE u.clienteId=:clienteId and  u.componenteventasenlineaId=:componenteventasenlineaId")
})
public class ComponenteVentasEnLineaClienteEntity implements Serializable {

    @Id
    @Column(name = "componenteventasenlineaId")
    private Long componenteventasenlineaId;
    @Id
    @Column(name = "clienteId")
    private Long clienteId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "clienteId", referencedColumnName = "id")
    @JoinFetch
    private ClienteEntity clienteEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "componenteventasenlineaId", referencedColumnName = "id")
    @JoinFetch
    private ComponenteVentasEnLineaEntity componenteventasenlineaEntity;

    public ComponenteVentasEnLineaClienteEntity() {
    }

    public ComponenteVentasEnLineaClienteEntity(Long componenteventasenlineaId, Long clienteId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
        this.clienteId = clienteId;
    }

    public Long getComponenteVentasEnLineaId() {
        return componenteventasenlineaId;
    }

    public void setComponenteVentasEnLineaId(Long componenteventasenlineaId) {
        this.componenteventasenlineaId = componenteventasenlineaId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public ComponenteVentasEnLineaEntity getComponenteVentasEnLineaEntity() {
        return componenteventasenlineaEntity;
    }

    public void setComponenteVentasEnLineaEntity(ComponenteVentasEnLineaEntity componenteventasenlineaEntity) {
        this.componenteventasenlineaEntity = componenteventasenlineaEntity;
    }

}
