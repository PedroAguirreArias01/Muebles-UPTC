package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Factura;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.banco.ClienteBanco;
import co.edu.uptc.sw2.proyectoangular.logica.ClienteBancoLogica;
import co.edu.uptc.sw2.proyectoangular.logica.ManejoExcepciones;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 * @author DANIELA
 */
@Stateless
public class FacturaDAO {
    
    @PersistenceContext(unitName = "com.mycompany_MueblesUPTC_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    @EJB
    private ClienteBancoLogica cbl;
    
    public List<Factura> getFactura(){
        String query = "Select e from Factura e";
        return em.createQuery(query).getResultList();
    }
    
    public Factura guardarFactura(Factura factura) throws Exception{
        String mensaje = "MONTO INSUFICIENTE";
         em.persist(factura);
        for (ClienteBanco clienteBanco : cbl.getClienteBanco()) {
            if (factura.getIdClienteFactura().getCedula().equals(clienteBanco.getCedula())) {
                if (clienteBanco.getIdTarjeta().getMonto()>= factura.getValorTotal()) {
                    clienteBanco.getIdTarjeta().setMonto(clienteBanco.getIdTarjeta().getMonto()-factura.getValorTotal());
                    cbl.transaccionBanco(clienteBanco);
                }else{
                   new ManejoExcepciones(mensaje);
                }
            }else{
                mensaje = "USUARIO NO ESTA REGISTRADO EN LA ENTIDAD BANCARIA";
                new ManejoExcepciones(mensaje);
            }
        }
        return  factura;
    }
    
    public void eliminarFactura(Factura factura){
        em.remove(em.find(Factura.class, factura.getIdFactura()));
    }
    
    public Factura editarFactura(Factura factura){
        return em.merge(factura);
    }
}
