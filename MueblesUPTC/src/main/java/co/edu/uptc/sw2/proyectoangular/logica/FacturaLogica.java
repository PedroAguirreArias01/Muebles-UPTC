/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.FacturaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Factura;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author PEDRO
 */
public class FacturaLogica {
     @EJB
    private FacturaDAO facturaDAO;
    
     public List<Factura> getFactura(){
        return facturaDAO.getFactura();
    }
    
    public Factura guardarFactura(Factura facturaDTO){
        return facturaDAO.guardarFactura(facturaDTO);
    }
    
    public void eliminarFactura(Factura facturaDTO){
        facturaDAO.eliminarFactura(facturaDTO);
    }
    
    public void ediatarFactura(Factura facturaDTO){
        facturaDAO.editarFactura(facturaDTO);
    }
}