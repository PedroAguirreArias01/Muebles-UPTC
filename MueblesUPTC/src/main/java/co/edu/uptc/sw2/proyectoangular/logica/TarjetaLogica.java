package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.banco.TarjetaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.Tarjeta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@Stateless
public class TarjetaLogica {
    
    @EJB
    private TarjetaDAO tarjetaDAO;
    
      public List<Tarjeta> getTargeta(){
        return tarjetaDAO.getTargeta();
    }
    
    public Tarjeta guardarTarjeta(Tarjeta tarjeta){
        return  tarjetaDAO.guardarTarjeta(tarjeta);
    }
    
    public void eliminarTarjeta(Tarjeta tarjeta){
        tarjetaDAO.eliminarTarjeta(tarjeta);
    }
    
    public Tarjeta editarTarjeta(Tarjeta tarjeta){
        return tarjetaDAO.editarTarjeta(tarjeta);
    }
}
