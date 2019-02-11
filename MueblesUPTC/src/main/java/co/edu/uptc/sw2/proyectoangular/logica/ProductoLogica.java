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
    private ProductoDAO facultadDAO;
    
    public List<Producto> getFacultades(){
        return facultadDAO.getProducto();
    }
    
    public Producto guardarFacultad(Producto facultadDTO){
        return facultadDAO.guardarProducto(facultadDTO);
    }
    
    public void eliminarFacultad(Producto facultadDTO){
        facultadDAO.eliminarProducto(facultadDTO);
    }
    
    public Producto editarFacultad(Producto facultadDTO){
        return facultadDAO.editarProducto(facultadDTO);
    }
}
