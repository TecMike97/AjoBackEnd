package org.generations.AjoDeBruja.model;

public class Categorias {
	private int id_categoria;
	private String nombre;
	private static int total = 0;

	public Categorias(String nombre) {
		super();
		this.nombre = nombre;
		Categorias.total++;
		id_categoria = Categorias.total;
	}

	public Categorias() {
		// TODO Auto-generated constructor stub
		Categorias.total++;
		id_categoria = Categorias.total;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categorias [id_categoria=" + id_categoria + ", nombre=" + nombre + "]";
	}

}
