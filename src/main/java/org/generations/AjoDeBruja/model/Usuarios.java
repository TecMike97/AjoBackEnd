package org.generations.AjoDeBruja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String contrasena;
	
	//Constructor y constructor vacío
	public Usuarios(String email, String contrasena) {
		super();
		this.email = email;
		this.contrasena = contrasena;
	}//constructor
	
	public Usuarios() {
	}//constructor vacío

	
	//Getters y Setters
	public Long getId() {
		return id;
	}//getId

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getContrasena() {
		return contrasena;
	}//getContrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", email=" + email + ", contrasena=" + contrasena + "]";
	}//toString
	
	
}//class Usuarios
