package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DetalleFacturaDTO")
@NamedQueries({
  
    @NamedQuery(name = "ConsultaClientes", query = "select df.idFacturaDTO.nombreCliente, SUM(df.valorTotal) from DetalleFacturaDTO df GROUP BY df.idFacturaDTO.nombreCliente"),
    @NamedQuery(name = "FacturadoEnBebidas", query = "SELECT SUM(df.valorTotal) from DetalleFacturaDTO df WHERE df.idProductoDTO.tipoProducto.nombre = :first"),
    @NamedQuery(name = "FacturadoEnDiciembre", query = "SELECT sum(df.valorTotal) from DetalleFacturaDTO df WHERE df.idFacturaDTO.fecha = :first"),
    @NamedQuery(name = "CuantoSeFacturo", query = "select sum(df.valorTotal) from DetalleFacturaDTO df WHERE df.idProductoDTO.nombre = :first AND df.idProductoDTO.nombre = :last"),
    @NamedQuery(name = "ProductoMasVendido", query = "select df.idProductoDTO, df.idProductoDTO.nombre, sum(df.cantidad) from DetalleFacturaDTO df group by df.idProductoDTO order by sum(df.cantidad)" ),
    @NamedQuery(name = "ProductoMenosVendido", query = "select df.idProductoDTO, df.idProductoDTO.nombre, sum(df.cantidad) from DetalleFacturaDTO df group by df.idProductoDTO order by sum(df.cantidad) "),
    @NamedQuery(name = "ConsultaVentas", query = "select sum(df.valorTotal) as totalVentas from DetalleFacturaDTO df"),
    //consultas nuevas
    @NamedQuery(name = "consultaValorFactura", query = "SELECT df.idFacturaDTO, "
            + "(((df.idProductoDTO.tipoProducto.iva)*df.idProductoDTO.valor)/100) as ValorIva, "
            + "df.idProductoDTO.valor,sum(df.valorTotal) from DetalleFacturaDTO df GROUP BY df.idFacturaDTO, "
            + "(((df.idProductoDTO.tipoProducto.iva)*df.idProductoDTO.valor)/100), df.idProductoDTO.valor"),
    @NamedQuery(name = "consultaValorFactura2018", query = "SELECT df.idFacturaDTO, (((df.idProductoDTO.tipoProducto.iva)*df.idProductoDTO.valor)/100) as ValorIva, df.idProductoDTO.valor,sum(df.valorTotal) from DetalleFacturaDTO df WHERE df.idFacturaDTO.fecha BETWEEN '2018-01-01' AND '2018-12-31'  GROUP BY df.idFacturaDTO, (((df.idProductoDTO.tipoProducto.iva)*df.idProductoDTO.valor)/100), df.idProductoDTO.valor"),
    @NamedQuery(name = "consultaValorFactura2019", query = "SELECT df.idFacturaDTO, (((df.idProductoDTO.tipoProducto.iva)*df.idProductoDTO.valor)/100) as ValorIva, df.idProductoDTO.valor,sum(df.valorTotal) from DetalleFacturaDTO df WHERE df.idFacturaDTO.fecha BETWEEN '2019-01-01' AND '2019-12-31'  GROUP BY df.idFacturaDTO, (((df.idProductoDTO.tipoProducto.iva)*df.idProductoDTO.valor)/100), df.idProductoDTO.valor")

})
public class DetalleFactura implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;
    @ManyToOne
    private Factura idFacturaDTO;
    @ManyToOne
    private Producto idProductoDTO;
    private int cantidad;
    private float valorTotal;

    public DetalleFactura() {
    }
    
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Factura getIdFacturaDTO() {
        return idFacturaDTO;
    }

    public void setIdFacturaDTO(Factura idFacturaDTO) {
        this.idFacturaDTO = idFacturaDTO;
    }

    public Producto getIdProductoDTO() {
        return idProductoDTO;
    }

    public void setIdProductoDTO(Producto idProductoDTO) {
        this.idProductoDTO = idProductoDTO;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "DetalleFacturaDTO{" + "idDetalle=" + idDetalle + ", idFacturaDTO=" + idFacturaDTO + ", idProductoDTO=" + idProductoDTO + ", cantidad=" + cantidad + ", valorTotal=" + valorTotal + '}';
    }
}
