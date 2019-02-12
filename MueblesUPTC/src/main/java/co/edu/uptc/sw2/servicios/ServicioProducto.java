/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Producto;
import co.edu.uptc.sw2.proyectoangular.logica.ProductoLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author PEDRO
 */
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
