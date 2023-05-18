package com.des.mdm.PFCMDM.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String correo_electronico;
	private String contrasena;
	private String direccion;
	private String telefono;
	private int estatus;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "usuarios_permiso", 
	joinColumns = @JoinColumn (name= "idUsuario"), 
	inverseJoinColumns = @JoinColumn(name = "idPermiso"))
	private List<Permisos> permisos;
	
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
	
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public List<Permisos> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<Permisos> permisos) {
		this.permisos = permisos;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", correo_electronico=" + correo_electronico + ", contrasena="
				+ contrasena + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	
	
}