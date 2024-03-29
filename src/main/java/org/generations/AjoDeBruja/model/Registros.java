package org.generations.AjoDeBruja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="registros")
public class Registros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro", unique = true, nullable = false)
	private Long id_registro;
	@Column(nullable=false)
	private String nombre_completo;
	@Column(nullable=false)
	private String telefono;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String contraseña;

	public Registros(String nombre_completo, String telefono, String email, String contraseña) {
		super();
		this.nombre_completo = nombre_completo;
		this.telefono = telefono;
		this.email = email;
		this.contraseña = contraseña;
	}//cnstructor

	public Registros() {
		// TODO Auto-generated constructor stub
	}//constrcutor vacío

	public Long getId_registro() {
		return id_registro;
	}//getId_registro

	public String getNombre_completo() {
		return nombre_completo;
	}//getNombre_completo

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}//setNombre_completo

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getContraseña() {
		return contraseña;
	}//getContraseña

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}//setContraseña

	@Override
	public String toString() {
		return "Registros [id_registro=" + id_registro + ", nombre_completo=" + nombre_completo + ", telefono="
				+ telefono + ", email=" + email + ", contraseña=" + contraseña + "]";
	}//toString

}//class Registros
