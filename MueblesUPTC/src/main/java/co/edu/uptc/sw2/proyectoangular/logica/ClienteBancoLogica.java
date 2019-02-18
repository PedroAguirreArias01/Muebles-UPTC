package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.banco.ClienteBancoDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.ClienteBanco;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 * @author DANIELA
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
    
    public ClienteBanco transaccionBanco(ClienteBanco clienteBanco){
        return clienteBancoDAO.transaccionBanco(clienteBanco);
    }
    
    
}
