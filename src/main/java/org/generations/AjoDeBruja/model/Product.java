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
	@Column(nullable=false)
	private String descripcion;
	@Column(nullable=false)
	private double precio;
	@Column(nullable=false)
	private String imagen;

	public Product(String nombre, String categoria, String descripcion, double precio, String imagen) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
	}//constructor

	public Product() {	
	}//constructor vacío

	public Long getId_producto() {
		return id_producto;
	}//getId_producto

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getCategoria() {
		return categoria;
	}//getCategoria

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}//setCategoria

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio

	public String getImagen() {
		return imagen;
	}//getImagen

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen

	@Override
	public String toString() {
		return "Product [id_producto=" + id_producto + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", descripcion=" + descripcion + ", precio=" + precio + ", imagen=" + imagen + "]";
	}//toString

}//class Product
