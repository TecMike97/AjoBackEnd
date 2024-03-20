package org.generations.AjoDeBruja.model;

public class Registros {
	private int id_registro;
	private String nombre_completo;
	private String telefono;
	private String email;
	private String contraseña;
	private static int total = 0;

	public Registros(String nombre_completo, String telefono, String email, String contraseña) {
		super();
		this.nombre_completo = nombre_completo;
		this.telefono = telefono;
		this.email = email;
		this.contraseña = contraseña;
		Registros.total++;
		id_registro = Registros.total;
	}

	public Registros() {
		// TODO Auto-generated constructor stub
		Registros.total++;
		id_registro = Registros.total;
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
