/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia.banco;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.ClienteBanco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
public class ClienteBancoDAO {
    
    @PersistenceContext( unitName = "com.mycompany_MueblesUPTC_war_1.0-SNAPSHOTPU2")
    private EntityManager em;
    
     public List<ClienteBanco> getClienteBanco(){
        String query = "Select e from ClienteBanco e";
        return em.createQuery(query).getResultList();
    }
    
    public ClienteBanco guardarClienteBanco(ClienteBanco clienteBanco){
        em.persist(clienteBanco);
        return  clienteBanco;
    }
    
    public void eliminarClienteBanco(ClienteBanco clienteBanco){
        em.remove(em.find(ClienteBanco.class, clienteBanco.getIdClienteBanco()));
    }
    
    public ClienteBanco editarClienteBanco(ClienteBanco clienteBanco){
        em.merge(clienteBanco);
        return clienteBanco;
    }
}
