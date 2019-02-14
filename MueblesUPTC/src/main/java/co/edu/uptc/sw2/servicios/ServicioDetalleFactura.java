package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.DetalleFacturaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.DetalleFactura;
import co.edu.uptc.sw2.proyectoangular.logica.DetalleFacturaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("ServicioDetalleFactura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicioDetalleFactura {

    @EJB
    private DetalleFacturaLogica dfl;

    @GET
    public List<DetalleFactura> getDetalleFactura() {
        return dfl.getDetalleFactura();
    }
    
    @POST
    public DetalleFactura guardarDetalles(DetalleFactura detalleFactura) {
        for (int i = 0; i < dfl.getDetalleFactura().size(); i++) {
            if (dfl.getDetalleFactura().get(i).getIdDetalle()== (detalleFactura.getIdDetalle())) {
                return dfl.editarDetalleFactura(detalleFactura);
            }
        }
        dfl.guardarDetalleFactura(detalleFactura);
        return detalleFactura;
    }
    
}
