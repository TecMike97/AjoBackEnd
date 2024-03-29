package org.generations.AjoDeBruja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name = "categorias")
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria", unique = true, nullable = false)
	private Long id_categoria;
	@Column(nullable=false)
	private String nombre;

	public Categorias(String nombre) {
		super();
		this.nombre = nombre;
	}//constructor

	public Categorias() {
	}//constructor vacío

	public Long getId_categoria() {
		return id_categoria;
	}//getId_categoria

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	@Override
	public String toString() {
		return "Categorias [id_categoria=" + id_categoria + ", nombre=" + nombre + "]";
	}//toString

}//class Categorias
