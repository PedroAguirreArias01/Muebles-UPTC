package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.ClienteDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ClienteFactura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@Stateless
public class ClienteFacturaLogica {
    
    @EJB
    private ClienteDAO clienteDAO;
    
     public List<ClienteFactura> getCliente(){
        return clienteDAO.getCliente();
    }
    
    public ClienteFactura guardarProducto(ClienteFactura cf){
        return  clienteDAO.guardarCliente(cf);
    }
    
    public void eliminarCliente(ClienteFactura cf){
        clienteDAO.eliminarCliente(cf);
    }
    
    public ClienteFactura editarCliente(ClienteFactura cf){
        return clienteDAO.editarCliente(cf);
    }
}
