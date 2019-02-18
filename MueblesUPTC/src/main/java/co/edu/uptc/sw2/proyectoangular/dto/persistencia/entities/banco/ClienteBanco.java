package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "listaBanco", query = "select e from ClienteBanco e")
})
public class ClienteBanco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClienteBanco;
    private String cedula;
    private String nombre;
    private Tarjeta idTarjeta;

    public ClienteBanco() {
    }
    
    public int getIdClienteBanco() {
        return idClienteBanco;
    }

    public void setIdClienteBanco(int idClienteBanco) {
        this.idClienteBanco = idClienteBanco;
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

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }
}
