package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.DetalleFacturaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("ServicioDetalleFactura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicioDetalleFactura {

    @EJB
    private DetalleFacturaDAO detalleFacturaDAO;

    @GET
    //      @Path("/getDetalles")
    public List<Object[]> getDetalleFactura() {
        System.out.println("error.........................................");

//        for (Object[] objects : detalleFacturaDAO.consultaValorFactura()) {
//            System.out.println("Factura" + objects[0].toString());
//            System.out.println("Valor Iva" + objects[1]);
//            System.out.println("Valor Real" + objects[2]);
//            System.out.println("Valor Total" + objects[3]);
//        }
//        System.out.println("Annio 2018.................................................................");
//        for (Object[] objects : detalleFacturaDAO.consultaValorFactura2018()) {
//
//            System.out.println("Factura" + objects[0].toString());
//            System.out.println("Valor Iva" + objects[1]);
//            System.out.println("Valor Real" + objects[2]);
//            System.out.println("Valor Total" + objects[3]);
//
//        }
//
//        System.out.println("Annio 2019.................................................................");
//        for (Object[] objects : detalleFacturaDAO.consultaValorFactura2019()) {
//
//            System.out.println("Factura" + objects[0].toString());
//            System.out.println("Valor Iva" + objects[1]);
//            System.out.println("Valor Real" + objects[2]);
//            System.out.println("Valor Total" + objects[3]);
//
//        }

//        for (Object object : detalleFacturaDAO.getConsultaClientes()) {
//            System.out.println("Clientes: " + object.toString().);
//        }
//        for (int i = 0; i < detalleFacturaDAO.getConsultaClientes().size(); i++) {
//            System.out.println("Clientes: " + detalleFacturaDAO.getConsultaClientes().get(i).getClass().toGenericString());
//
//        }
//        System.out.println("Producto Menos Vendido: " + detalleFacturaDAO.productoMenosVendido().toString());
//        System.err.println("Total de ventas = " + detalleFacturaDAO.consultaVentas().toString());
//        for (Object object : detalleFacturaDAO.getDetalles()) {
//            System.out.println("detalles: "+object.toString());
//        }
        return null;
    }
}
