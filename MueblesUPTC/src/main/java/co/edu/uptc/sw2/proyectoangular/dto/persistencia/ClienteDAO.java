/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ClienteFactura;
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
public class ClienteDAO {
     @PersistenceContext
    private EntityManager em;
    
    public List<Producto> getCliente(){
        String query = "Select e from ClienteFactura e";
        return em.createQuery(query).getResultList();
    }
    
    public ClienteFactura guardarProducto(ClienteFactura cf){
        em.persist(cf);
        return  cf;
    }
    
    public void eliminarCliente(ClienteFactura cf){
        em.remove(em.find(Producto.class, cf.getIdClienteFactura()));
    }
    
    public ClienteFactura editarCliente(ClienteFactura cf){
        em.merge(cf);
        return cf;
    }
}
