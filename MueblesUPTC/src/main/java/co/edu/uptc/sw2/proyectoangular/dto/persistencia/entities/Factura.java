package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Factura {

    @OneToMany(mappedBy = "idFactura",orphanRemoval=true, cascade={CascadeType.ALL})
    private List<DetalleFactura> detalleFactura;
    private String nombreCliente;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;
    private Date fecha;

    public Factura() {
    }
    
    

    public List<DetalleFactura> getDetalleFacturaDTOs() {
        return detalleFactura;
    }

    public void setDetalleFacturaDTOs(List<DetalleFactura> detalleFacturaDTOs) {
        this.detalleFactura = detalleFacturaDTOs;
    }
    
    

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    @Override
    public String toString() {
        return "FacturaDTO{" + "detalleFacturaDTOs=" + detalleFactura + ", nombreCliente=" + nombreCliente + ", idFactura=" + idFactura + ", fecha=" + fecha + '}';
    }
}
