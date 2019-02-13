/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.servicios.banco;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.ClienteBanco;
import co.edu.uptc.sw2.proyectoangular.logica.ClienteBancoLogica;
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
@Path("ServicioClienteBanco")
public class ServicioClienteBanco {
    
    @EJB
    private ClienteBancoLogica cbl;
    
    @GET
    public List<ClienteBanco> getClienteBanco(){
        return cbl.getClienteBanco();
    }
}
