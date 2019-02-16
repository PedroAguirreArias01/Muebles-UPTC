package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Factura implements Serializable{

    @OneToMany(mappedBy = "idFactura",orphanRemoval=true, cascade={CascadeType.ALL})
    private List<DetalleFactura> detalleFactura;
    @ManyToOne
    private ClienteFactura idClienteFactura;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;
    //@Formats.DateTime(pattern = "dd-mm-yyyy");
    //@Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Factura() {
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public ClienteFactura getIdClienteFactura() {
        return idClienteFactura;
    }

    public void setIdClienteFactura(ClienteFactura idClienteFactura) {
        this.idClienteFactura = idClienteFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
