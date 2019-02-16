package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.ProductoDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProductoLogica {
    
    @EJB
    private ProductoDAO productoDAO;
    
    public List<Producto> getProducto(){
        return productoDAO.getProducto();
    }
    
    public Producto guardarProducto(Producto producto){
        return productoDAO.guardarProducto(producto);
    }
    
    public void eliminarProducto(Producto producto){
        productoDAO.eliminarProducto(producto);
    }
    
    public Producto editarProducto(Producto producto){
        return productoDAO.editarProducto(producto);
    }
}
