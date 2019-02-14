package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@Entity
public class ClienteFactura implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClienteFactura;
    private String cedula;
    private String nombre;

    public ClienteFactura() {
    }
    
    public int getIdClienteFactura() {
        return idClienteFactura;
    }

    public void setIdClienteFactura(int idClienteFactura) {
        this.idClienteFactura = idClienteFactura;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
