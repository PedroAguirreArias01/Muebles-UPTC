package co.edu.uptc.sw2.servicios.banco;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.Tarjeta;
import co.edu.uptc.sw2.proyectoangular.logica.TarjetaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@Stateless
@Path("ServicoTarjeta")
public class ServicoTarjeta {
    
    @EJB
    private TarjetaLogica tl;
    
    @GET
    public List<Tarjeta> getTargetas(){
        return tl.getTargeta();
    }
    
}
 