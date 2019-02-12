/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

/**
 *
 * @author PEDRO
 */
@javax.ejb.ApplicationException(rollback = true)
public class ManejoExcepciones extends RuntimeException{
    
    public ManejoExcepciones(String mensaje) {
        super(mensaje);
    }
    
}
