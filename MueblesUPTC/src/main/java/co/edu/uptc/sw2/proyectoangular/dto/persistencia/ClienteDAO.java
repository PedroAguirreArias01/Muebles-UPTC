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
    
    @PersistenceContext( unitName = "com.mycompany_MueblesUPTC_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public List<ClienteFactura> getCliente(){
        String query = "Select e from ClienteFactura e";
        return em.createQuery(query).getResultList();
    }
    
    public ClienteFactura guardarCliente(ClienteFactura clienteFactura){
        em.persist(clienteFactura);
        return  clienteFactura;
    }
    
    public void eliminarCliente(ClienteFactura clienteFactura){
        em.remove(em.find(Producto.class, clienteFactura.getIdClienteFactura()));
    }
    
    public ClienteFactura editarCliente(ClienteFactura clienteFactura){
        em.merge(clienteFactura);
        return clienteFactura;
    }
}
