package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Factura;
import co.edu.uptc.sw2.proyectoangular.logica.FacturaLogica;
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
@Path("ServicioFactura")
public class ServicioFactura {
    
    @EJB
    private FacturaLogica facturaLogica;
    
    @GET
    public List<Factura> getFacturas(){
        return facturaLogica.getFactura();
    }
    
    @POST
    public Factura guardarFactura(Factura factura) {
        for (int i = 0; i < facturaLogica.getFactura().size(); i++) {
            if (facturaLogica.getFactura().get(i).getIdFactura()== (factura.getIdFactura())) {
                return facturaLogica.editarFactura(factura);
            }
        }
        facturaLogica.guardarFactura(factura);
        return factura;
    }
}
