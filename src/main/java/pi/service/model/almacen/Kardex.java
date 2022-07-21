package pi.service.model.almacen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import pi.service.factory.Numbers;
import pi.service.util.Util;
import pi.service.util.db.client.TableDB;

@TableDB(name = "almacen.kardex")
public class Kardex implements Serializable {

	public Integer id;
	public String creador;
	public Boolean activo;
	public Integer orden_id;
	public String documento;
	public Date fecha;
	public Date fecha_orden;
	public Character movimiento; // E S
	public Character tipo; // V C T R
	public Almacen almacen;
	public Producto producto;
	public String origen;
	public String destino;
	public BigDecimal precio_costo;
	public BigDecimal precio_venta;
	public BigDecimal stock_anterior;
	public BigDecimal ingreso;
	public BigDecimal salida;
	public BigDecimal stock;
	public Date fecha_vencimiento;
	public String lote;
	public BigDecimal usado;
	public String identificador;

	@Override
	public String toString() {
		return movimiento + "-" + id;
	}

	public BigDecimal getSTockAnterior() {
		return Numbers.getBD(stock_anterior, 2);
	}

	public BigDecimal getIngreso() {
		return Numbers.getBD(ingreso, 2);
	}

	public BigDecimal getSalida() {
		return Numbers.getBD(salida, 2);
	}

	public BigDecimal getStock() {
		return Numbers.getBD(stock, 2);
	}

	public BigDecimal getStockConversion() {
		return Numbers.getBD(stock.multiply(producto.factor_conversion), 2);
	}

	public String getMotivo() {
		String motivo = "-";
		if (tipo == Util.TIPO_ORDEN_COMPRA) {
			motivo = "COMPRA";
		}
		if (tipo == Util.TIPO_ORDEN_REGULARIZACION) {
			motivo = "REGULARIZACION";
		}
		if (tipo == Util.TIPO_ORDEN_TRASLADO) {
			motivo = "TRASLADO";
		}
		if (tipo == Util.TIPO_ORDEN_VENTA) {
			motivo = "VENTA";
		}
		return motivo;
	}

	public String getDocumento() {
		return documento;
	}

	public Date getFecha_orden() {
		return fecha_orden;
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public BigDecimal getPrecio_costo() {
		return Numbers.getBD(precio_costo, 2);
	}

	public BigDecimal getPrecio_venta() {
		return Numbers.getBD(precio_venta, 2);
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public String getLote() {
		return lote;
	}

	public BigDecimal getUsado() {
		return Numbers.getBD(usado, 2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kardex other = (Kardex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
