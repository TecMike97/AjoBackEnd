package org.generations.AjoDeBruja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido", unique = true, nullable = false)
	private int id_pedido;
	@Column(nullable=false)
	private int cantidad_productos;
	@Column(nullable=false)
	private double precio_total;


	public Pedidos(int cantidad_productos, double precio_total) {
		super();
		this.cantidad_productos = cantidad_productos;
		this.precio_total = precio_total;
		
	}

	public Pedidos() {
		
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public int getCantidad_productos() {
		return cantidad_productos;
	}

	public void setCantidad_productos(int cantidad_productos) {
		this.cantidad_productos = cantidad_productos;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	@Override
	public String toString() {
		return "Pedidos [id_pedido=" + id_pedido + ", cantidad_productos=" + cantidad_productos + ", precio_total="
				+ precio_total + "]";
	}

}
