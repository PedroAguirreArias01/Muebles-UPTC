/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.banco.ClienteBancoDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.ClienteBanco;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class ClienteBancoLogica {
    
    @EJB
    private ClienteBancoDAO clienteBancoDAO;
    
    public List<ClienteBanco> getClienteBanco(){
        return clienteBancoDAO.getClienteBanco();
    }
    
    public ClienteBanco guardarClienteBanco(ClienteBanco clienteBanco){
        return  clienteBancoDAO.guardarClienteBanco(clienteBanco);
    }
    
    public void eliminarClienteBanco(ClienteBanco clienteBanco){
        clienteBancoDAO.eliminarClienteBanco(clienteBanco);
    }
    
    public ClienteBanco editarClienteBanco(ClienteBanco clienteBanco){
        return clienteBancoDAO.editarClienteBanco(clienteBanco);
    }
    
}
