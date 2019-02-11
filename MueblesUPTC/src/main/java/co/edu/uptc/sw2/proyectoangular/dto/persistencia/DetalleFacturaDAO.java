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
    
    @PersistenceContext
    private EntityManager em;
    
    public List<DetalleFactura> getDetalleFactura(){
        String query = "Select e from DetalleFacturaDTO e";
        return em.createQuery(query).getResultList();
    }
    
    public List<Object> getConsultaClientes(){
        return (List<Object>)em.createNamedQuery("ConsultaClientes").getResultList();
    }
    
    public List<Object> consultaVentas(){
        return (List<Object>) em.createNamedQuery("ConsultaVentas").getResultList();
    }
    
    public Object productoMenosVendido(){
        return (Object)em.createNamedQuery("ProductoMenosVendido").getResultList().get(0);
    }
    
    public List<Object[]> consultaValorFactura(){
        List<Object[]> list = em.createNamedQuery("consultaValorFactura").getResultList();
        return list;
    }
    
    public  List<Object[]> consultaValorFactura2018(){
        List<Object[]> list = em.createNamedQuery("consultaValorFactura2018").getResultList();
        return list;
    }
    
    public  List<Object[]> consultaValorFactura2019(){
        List<Object[]> list = em.createNamedQuery("consultaValorFactura2019").getResultList();
        return list;
    }
    
    public DetalleFactura guardarDetalleFactura(DetalleFactura detalleFacturaDTO){
        em.persist(detalleFacturaDTO);
        return  detalleFacturaDTO;
    }
    
    public void eliminarDetalleFactura(DetalleFactura detalleFacturaDTO){
        em.remove(em.find(DetalleFactura.class, detalleFacturaDTO.getIdDetalle()));
    }
    
    public void editarDetalleFactura(DetalleFactura detalleFacturaDTO){
        em.merge(detalleFacturaDTO);
    }
}
