package com.des.mdm.PFCMDM.model;

public class User {
	
	private Integer id;
	private String nombre;
	private String correo_electronico;
	private String contrasena;
	private String direccion;
	private String telefono;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", correo_electronico=" + correo_electronico + ", contrasena="
				+ contrasena + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	
	
}