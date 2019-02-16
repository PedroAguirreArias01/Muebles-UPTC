package co.edu.uptc.sw2.proyectoangular.logica;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@javax.ejb.ApplicationException(rollback = true)
public class ManejoExcepciones extends RuntimeException{
    
    public ManejoExcepciones(String mensaje) {
        super(mensaje);
    }
    
}
