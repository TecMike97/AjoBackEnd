package org.generations.AjoDeBruja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object
@Entity
@Table(name="clientes")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", unique = true, nullable = false)
	private Long id_cliente;
	@Column(nullable=false)
	private String nombre;
	private String apellido_pa;
	private String apellido_ma;
	private String email;
	private String  telefono;

	public Clientes(String nombre, String apellido_pa, String apellido_ma, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido_pa = apellido_pa;
		this.apellido_ma = apellido_ma;
		this.email = email;
		this.telefono = telefono;
	}

	public Clientes() {
		// TODO Auto-generated constructor stub
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_pa() {
		return apellido_pa;
	}

	public void setApellido_pa(String apellido_pa) {
		this.apellido_pa = apellido_pa;
	}

	public String getApellido_ma() {
		return apellido_ma;
	}

	public void setApellido_ma(String apellido_ma) {
		this.apellido_ma = apellido_ma;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellido_pa=" + apellido_pa
				+ ", apellido_ma=" + apellido_ma + ", email=" + email + ", telefono=" + telefono + "]";
	}

}
