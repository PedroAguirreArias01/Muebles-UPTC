/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Factura;
import co.edu.uptc.sw2.proyectoangular.logica.FacturaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author PEDRO
 */
@Stateless
@Path("ServicioFactura")
public class ServicioFactura {
    
    @EJB
    private FacturaLogica facturaLogica;
    
    public List<Factura> getFacturas(){
        return facturaLogica.getFactura();
    }
}
