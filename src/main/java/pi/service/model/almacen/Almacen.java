package pi.service.model.almacen;

import java.io.Serializable;

import pi.service.model.empresa.Sucursal;
import pi.service.util.Util;
import pi.service.util.db.client.TableDB;


@TableDB(name="logistica.almacen")
public class Almacen implements Serializable {
	
	public Integer id;
	public Sucursal sucursal;
	public String codigo;
	public String descripcion;
	public Boolean activo;
	public String creador;
	public Boolean es_para_venta;
	public Boolean es_principal;

	public Sucursal getSucursal() {
		return sucursal;
	}

	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public String getActivoStr() {
		return activo?Util.SI:Util.NO;
	}

	public String getEsParaVentaStr() {
		return es_para_venta?Util.SI:Util.NO;
	}

	public String getEsPrincipalStr() {
		return es_principal?Util.SI:Util.NO;
	}

	public Boolean getEs_para_venta() {
		return es_para_venta;
	}

	public Boolean getEs_principal() {
		return es_principal;
	}
	
	@Override
	public String toString() {
		return codigo;
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
		Almacen other = (Almacen) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
