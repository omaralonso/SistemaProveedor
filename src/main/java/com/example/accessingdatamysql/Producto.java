package com.example.accessingdatamysql;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TSA_PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_producto")
	private Integer idProducto;

	@Column(name = "id_categoria")
	private Integer idCategoria;

	@Column(name = "nombre_producto")
	private String nombreProducto;

	@Column(name = "precio_producto")
	private BigDecimal precioProducto;

	@Column(name = "puntos_producto")
	private int puntosProducto;

	@Column(name = "stock_producto")
	private int stockProducto;

	@Column(name = "imagen_producto")
	private String imagenProducto;

	@Column(name = "estado_producto")
	private int estadoProducto;

	@Column(name = "descripcion_producto")
	private String descripcionProducto;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public BigDecimal getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(BigDecimal precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getPuntosProducto() {
		return puntosProducto;
	}

	public void setPuntosProducto(int puntosProducto) {
		this.puntosProducto = puntosProducto;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public String getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public int getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(int estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	@Override
	public String toString() {
		return "Producto {idProducto=" + idProducto + ", idCategoria=" + idCategoria + ", nombreProducto="
				+ nombreProducto + ", precioProducto=" + precioProducto + ", puntosProducto=" + puntosProducto
				+ ", stockProducto=" + stockProducto + ", imagenProducto=" + imagenProducto + ", estadoProducto="
				+ estadoProducto + ", descripcionProducto=" + descripcionProducto + "}";
	}

}
