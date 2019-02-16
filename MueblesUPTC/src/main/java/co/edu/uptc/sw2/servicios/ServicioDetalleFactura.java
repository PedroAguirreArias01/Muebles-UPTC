package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.DetalleFactura;
import co.edu.uptc.sw2.proyectoangular.logica.DetalleFacturaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("ServicioDetalleFactura")
public class ServicioDetalleFactura {

    @EJB
    private DetalleFacturaLogica detalleFacturaLogica;

    @GET
    public List<DetalleFactura> getDetalleFactura() {
        return detalleFacturaLogica.getDetalleFactura();
    }
    
    @POST
    public DetalleFactura guardarDetalles(DetalleFactura detalleFactura) {
        for (int i = 0; i < detalleFacturaLogica.getDetalleFactura().size(); i++) {
            if (detalleFacturaLogica.getDetalleFactura().get(i).getIdDetalle()== (detalleFactura.getIdDetalle())) {
                return detalleFacturaLogica.editarDetalleFactura(detalleFactura);
            }
        }
        detalleFacturaLogica.guardarDetalleFactura(detalleFactura);
        return detalleFactura;
    }
}
