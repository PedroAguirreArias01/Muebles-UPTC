/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.DetalleFacturaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.DetalleFactura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class DetalleFacturaLogica {
    
    @EJB
    private DetalleFacturaDAO df;
    
    public List<DetalleFactura> getDetalleFactura(){
        return df.getDetalleFactura();
    }
    
    public DetalleFactura guardarDetalleFactura(DetalleFactura matriculaDTO){
        return df.guardarDetalleFactura(matriculaDTO);
    }
    
    public void eliminarDetalleFactura(DetalleFactura matriculaDTO){
        df.eliminarDetalleFactura(matriculaDTO);
    }
    
    public DetalleFactura editarDetalleFactura(DetalleFactura detalleFactura){
        return df.editarDetalleFactura(detalleFactura);
    }
}
