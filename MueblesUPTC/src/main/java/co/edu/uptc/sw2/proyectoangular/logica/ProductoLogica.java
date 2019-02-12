/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.ProductoDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
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
