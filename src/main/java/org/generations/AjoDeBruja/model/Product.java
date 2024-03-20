package org.generations.AjoDeBruja.model;

public class Product {
	private int id_producto;
	private String nombre;
	private String categoria;
	private String descripcion;
	private double precio;
	private String imagen;
	private static int total = 0;

	public Product(String nombre, String categoria, String descripcion, double precio, String imagen) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		Product.total++;
		id_producto = Product.total;
	}

	public Product() {
		// TODO Auto-generated constructor stub
		Product.total++;
		id_producto = Product.total;
	}

	public int getId_producto() {
		return id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Product [id_producto=" + id_producto + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", descripcion=" + descripcion + ", precio=" + precio + ", imagen=" + imagen + "]";
	}

}
