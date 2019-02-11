/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */

@Stateless
public class ProductoDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Producto> getProducto(){
        String query = "Select e from Producto e";
        return em.createQuery(query).getResultList();
    }
    
    public Producto guardarProducto(Producto productoDTO){
        em.persist(productoDTO);
        return  productoDTO;
    }
    
    public void eliminarProducto(Producto productoDTO){
        em.remove(em.find(Producto.class, productoDTO.getIdProducto()));
    }
    
    public Producto editarProducto(Producto productoDTO){
        em.merge(productoDTO);
        return productoDTO;
    }
}
