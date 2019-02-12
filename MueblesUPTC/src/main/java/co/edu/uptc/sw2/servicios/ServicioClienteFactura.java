/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ClienteFactura;
import co.edu.uptc.sw2.proyectoangular.logica.ClienteFacturaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author PEDRO
 */
@Stateless
@Path("ServicioClienteFactura")
public class ServicioClienteFactura {
    
    @EJB
    private ClienteFacturaLogica clienteLogica;

    @GET
    public List<ClienteFactura> getCliente(){
        return clienteLogica.getCliente();
    }
    
}
