/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class FacturaDAO {
    
    @PersistenceContext( unitName = "com.mycompany_MueblesUPTC_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public List<Factura> getFactura(){
        String query = "Select e from Factura e";
        return em.createQuery(query).getResultList();
    }
    
    public Factura guardarFactura(Factura factura){
        em.persist(factura);
        return  factura;
    }
    
    public void eliminarFactura(Factura factura){
        em.remove(em.find(Factura.class, factura.getIdFactura()));
    }
    
    public Factura editarFactura(Factura factura){
        return em.merge(factura);
    }
}
