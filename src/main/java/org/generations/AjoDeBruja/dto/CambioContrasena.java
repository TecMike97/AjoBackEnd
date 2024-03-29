package org.generations.AjoDeBruja.dto;

public class CambioContrasena {
	private String contrasena;
	private String ncontrasena;
	public CambioContrasena(String contrasena, String ncontrasena) {
		super();
		this.contrasena = contrasena;
		this.ncontrasena = ncontrasena;
	}//constructor
	
	public CambioContrasena() {
	}//constructor vacío
	
	public String getContrasena() {
		return contrasena;
	}//getContrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena
	public String getNcontrasena() {
		return ncontrasena;
	}//getNcontrasena

	public void setNcontrasena(String ncontrasena) {
		this.ncontrasena = ncontrasena;
	}//setNcontrasena

	@Override
	public String toString() {
		return "CambioContrasena [contrasena=" + contrasena + ", ncontrasena=" + ncontrasena + "]";
	}//toString


}//class CambioContrasena
