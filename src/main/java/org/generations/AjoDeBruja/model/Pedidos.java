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
	private Long id_pedido;
	@Column(nullable=false)
	private Long cantidad_productos;
	@Column(nullable=false)
	private Double precio_total;


	public Pedidos(Long cantidad_productos, Double precio_total) {
		super();
		this.cantidad_productos = cantidad_productos;
		this.precio_total = precio_total;
		
	}//constructor

	public Pedidos() {
	}//constructor vacío

	public Long getId_pedido() {
		return id_pedido;
	}//getId_pedido

	public Long getCantidad_productos() {
		return cantidad_productos;
	}//getCantidad_productos

	public void setCantidad_productos(Long cantidad_productos) {
		this.cantidad_productos = cantidad_productos;
	}//setCantidad_productos

	public Double getPrecio_total() {
		return precio_total;
	}//getPrecio_total

	public void setPrecio_total(Double precio_total) {
		this.precio_total = precio_total;
	}//setPrecio_total

	@Override
	public String toString() {
		return "Pedidos [id_pedido=" + id_pedido + ", cantidad_productos=" + cantidad_productos + ", precio_total="
				+ precio_total + "]";
	}//toString

}//class Pedidos
