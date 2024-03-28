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
	private int id_registro;
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
	}

	public Registros() {
		// TODO Auto-generated constructor stub
	}

	public int getId_registro() {
		return id_registro;
	}

	public void setId_registro(int id_registro) {
		this.id_registro = id_registro;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Registros [id_registro=" + id_registro + ", nombre_completo=" + nombre_completo + ", telefono="
				+ telefono + ", email=" + email + ", contraseña=" + contraseña + "]";
	}

}
