/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.DetalleFacturaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.DetalleFactura;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class DetalleFacturaLogica {
    
    @EJB
    private DetalleFacturaDAO detalleFactura;
    
    public DetalleFactura guardarDetalleFactura(DetalleFactura matriculaDTO){
        return detalleFactura.guardarDetalleFactura(matriculaDTO);
    }
    
    public void eliminarDetalleFactura(DetalleFactura matriculaDTO){
        detalleFactura.eliminarDetalleFactura(matriculaDTO);
    }
    
    public void ediatarDetalleFactura(DetalleFactura matriculaDTO){
        detalleFactura.editarDetalleFactura(matriculaDTO);
    }
}
