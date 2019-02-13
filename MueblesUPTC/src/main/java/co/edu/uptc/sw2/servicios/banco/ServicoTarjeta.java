/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.servicios.banco;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.Tarjeta;
import co.edu.uptc.sw2.proyectoangular.logica.TarjetaLogica;
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
@Path("ServicoTarjeta")
public class ServicoTarjeta {
    
    @EJB
    private TarjetaLogica tl;
    
    @GET
    public List<Tarjeta> getTargetas(){
        return tl.getTargeta();
    }
    
}
 