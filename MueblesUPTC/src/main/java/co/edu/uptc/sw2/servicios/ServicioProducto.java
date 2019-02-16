package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Producto;
import co.edu.uptc.sw2.proyectoangular.logica.ProductoLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("ServicioProducto")
public class ServicioProducto {
    
    @EJB
    private ProductoLogica productoLogica;
    
    @GET
    public List<Producto> getProductos(){
        return productoLogica.getProducto();
    }
}
