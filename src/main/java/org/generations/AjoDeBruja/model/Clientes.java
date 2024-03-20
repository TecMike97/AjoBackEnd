package org.generations.AjoDeBruja.model;


public class Clientes {
	private int id_cliente;
	private String nombre;
	private String apellido_pa;
	private String apellido_ma;
	private String email;
	private String  telefono;
	private static int total = 0;

	public Clientes(String nombre, String apellido_pa, String apellido_ma, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido_pa = apellido_pa;
		this.apellido_ma = apellido_ma;
		this.email = email;
		this.telefono = telefono;
		Clientes.total++;
		id_cliente = Clientes.total;
	}

	public Clientes() {
		// TODO Auto-generated constructor stub
		Clientes.total++;
		id_cliente = Clientes.total;
	}

	public int getId_cliente() {
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
