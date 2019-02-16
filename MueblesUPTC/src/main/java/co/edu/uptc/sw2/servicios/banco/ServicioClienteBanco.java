package co.edu.uptc.sw2.servicios.banco;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.ClienteBanco;
import co.edu.uptc.sw2.proyectoangular.logica.ClienteBancoLogica;
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
@Path("ServicioClienteBanco")
public class ServicioClienteBanco {
    
    @EJB
    private ClienteBancoLogica cbl;
    
    @GET
    public List<ClienteBanco> getClienteBanco(){
        return cbl.getClienteBanco();
    }
}
