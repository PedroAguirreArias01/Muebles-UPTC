package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.DetalleFacturaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.DetalleFactura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DetalleFacturaLogica {
    
    @EJB
    private DetalleFacturaDAO detalleFacturaDAO;
    
    public List<DetalleFactura> getDetalleFactura(){
        return detalleFacturaDAO.getDetalleFactura();
    }
    
    public DetalleFactura guardarDetalleFactura(DetalleFactura matriculaDTO){
        return detalleFacturaDAO.guardarDetalleFactura(matriculaDTO);
    }
    
    public void eliminarDetalleFactura(DetalleFactura matriculaDTO){
        detalleFacturaDAO.eliminarDetalleFactura(matriculaDTO);
    }
    
    public DetalleFactura editarDetalleFactura(DetalleFactura detalleFactura){
        return detalleFacturaDAO.editarDetalleFactura(detalleFactura);
    }
}
