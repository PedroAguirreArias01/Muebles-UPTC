/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia.banco;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.Tarjeta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class TarjetaDAO {
    
    @PersistenceContext( unitName = "com.mycompany_MueblesUPTC_war_1.0-SNAPSHOTPU2")
    private EntityManager em;
    
    public List<Tarjeta> getTargeta(){
        String query = "Select e from Tarjeta e";
        return em.createQuery(query).getResultList();
    }
    
    public Tarjeta guardarTarjeta(Tarjeta tarjeta){
        em.persist(tarjeta);
        return  tarjeta;
    }
    
    public void eliminarTarjeta(Tarjeta tarjeta){
        em.remove(em.find(Tarjeta.class, tarjeta.getIdTarjeta()));
    }
    
    public Tarjeta editarTarjeta(Tarjeta tarjeta){
        em.merge(tarjeta);
        return tarjeta;
    }
}
