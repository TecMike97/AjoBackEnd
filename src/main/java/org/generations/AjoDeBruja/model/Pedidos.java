package org.generations.AjoDeBruja.model;

public class Pedidos {
	private int id_pedido;
	private int cantidad_productos;
	private double precio_total;
	private static int total = 0;

	public Pedidos(int cantidad_productos, double precio_total) {
		super();
		this.cantidad_productos = cantidad_productos;
		this.precio_total = precio_total;
		Pedidos.total++;
		id_pedido = Pedidos.total;
	}

	public Pedidos() {
		// TODO Auto-generated constructor stub
		Pedidos.total++;
		id_pedido = Pedidos.total;
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
