package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.FacturaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.Factura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class FacturaLogica {

    @EJB
    private FacturaDAO facturaDAO;

    public List<Factura> getFactura() {
        return facturaDAO.getFactura();
    }

    public Factura guardarFactura(Factura facturaDTO) {
        return facturaDAO.guardarFactura(facturaDTO);
    }

    public void eliminarFactura(Factura facturaDTO) {
        facturaDAO.eliminarFactura(facturaDTO);
    }

    public Factura editarFactura(Factura facturaDTO) {
        return facturaDAO.editarFactura(facturaDTO);
    }
}
