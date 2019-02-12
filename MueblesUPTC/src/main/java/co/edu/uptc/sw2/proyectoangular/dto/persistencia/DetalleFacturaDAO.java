/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.DetalleFactura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class DetalleFacturaDAO {
    
    @PersistenceContext( unitName = "com.mycompany_MueblesUPTC_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public List<DetalleFactura> getDetalleFactura(){
        String query = "Select e from DetalleFactura e";
        return em.createQuery(query).getResultList();
    }
    
//    public List<Object[]> consultaValorFactura(){
//        List<Object[]> list = em.createNamedQuery("consultaValorFactura").getResultList();
//        return list;
//    }
    
    public DetalleFactura guardarDetalleFactura(DetalleFactura detalleFactura){
        em.persist(detalleFactura);
        return  detalleFactura;
    }
    
    public void eliminarDetalleFactura(DetalleFactura detalleFactura){
        em.remove(em.find(DetalleFactura.class, detalleFactura.getIdDetalle()));
    }
    
    public void editarDetalleFactura(DetalleFactura detalleFactura){
        em.merge(detalleFactura);
    }
}
