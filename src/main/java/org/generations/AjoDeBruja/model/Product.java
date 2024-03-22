package org.generations.AjoDeBruja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="productos")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true,nullable=false)
	private Long id_producto;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String categoria;
	private String descripcion;
	private double precio;
	private String imagen;

	public Product(String nombre, String categoria, String descripcion, double precio, String imagen) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getId_producto() {
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

	public void setPrecio(double precio) {
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
