package com.example.accessingdatamysql;

import java.io.Serializable;

public class ActualizarRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idProducto;
	private int cantidadProductos;

	public ActualizarRequest() {

	}

	public ActualizarRequest(int idProducto, int cantidadProductos) {
		super();
		this.idProducto = idProducto;
		this.cantidadProductos = cantidadProductos;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	@Override
	public String toString() {
		return "ActualizarRequest [idProducto=" + idProducto + ", cantidadProductos=" + cantidadProductos + "]";
	}

}
