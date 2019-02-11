/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author PEDRO
 */
@Entity
public class ClienteBanco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClienteFactura;
    private String cedula;
    private String nombre;
    @OneToOne
    private Tarjeta idTarjeta;

    public ClienteBanco() {
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

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }
    
    
}
