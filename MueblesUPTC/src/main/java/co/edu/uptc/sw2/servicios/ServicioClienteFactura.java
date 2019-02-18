package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ClienteFactura;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.DetalleFactura;
import co.edu.uptc.sw2.proyectoangular.logica.ClienteFacturaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@Stateless
@Path("ServicioClienteFactura")
public class ServicioClienteFactura {

    @EJB
    private ClienteFacturaLogica clienteLogica;

    @GET
    public List<ClienteFactura> getCliente() {
        return clienteLogica.getCliente();
    }

    @POST
    public ClienteFactura guardarCliente(ClienteFactura clienteFactura) {
        for (int i = 0; i < clienteLogica.getCliente().size(); i++) {
            if (clienteLogica.getCliente().get(i).getIdClienteFactura() == (clienteFactura.getIdClienteFactura())) {
                return clienteLogica.editarCliente(clienteFactura);
            }
        }
        clienteLogica.guardarClienteFactura(clienteFactura);
        return clienteFactura;
    }
}
