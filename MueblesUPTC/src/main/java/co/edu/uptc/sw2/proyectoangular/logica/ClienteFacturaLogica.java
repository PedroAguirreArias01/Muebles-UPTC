/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.ClienteDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ClienteFactura;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class ClienteFacturaLogica {
    
    @EJB
    private ClienteDAO clienteDAO;
    
     public List<Producto> getCliente(){
        return clienteDAO.getCliente();
    }
    
    public ClienteFactura guardarProducto(ClienteFactura cf){
        return  clienteDAO.guardarProducto(cf);
    }
    
    public void eliminarCliente(ClienteFactura cf){
        clienteDAO.eliminarCliente(cf);
    }
    
    public ClienteFactura editarCliente(ClienteFactura cf){
        return clienteDAO.editarCliente(cf);
    }
}
