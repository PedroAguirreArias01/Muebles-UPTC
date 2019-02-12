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
    
    @PersistenceContext( unitName = "com.mycompany_MueblesUPTC_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public List<Producto> getProducto(){
        String query = "Select e from Producto e";
        return em.createQuery(query).getResultList();
    }
    
    public Producto guardarProducto(Producto producto){
        em.persist(producto);
        return  producto;
    }
    
    public void eliminarProducto(Producto producto){
        em.remove(em.find(Producto.class, producto.getIdProducto()));
    }
    
    public Producto editarProducto(Producto producto){
        em.merge(producto);
        return producto;
    }
}
