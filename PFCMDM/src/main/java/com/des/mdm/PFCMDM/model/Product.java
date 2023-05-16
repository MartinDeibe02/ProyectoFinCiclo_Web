package com.des.mdm.PFCMDM.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Product {
	
	private Integer id;
	
	private String nombre;
	
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	private double precio;
	
	private Brand marca_id;
	
	private String product_image;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Brand getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(Brand marca_id) {
		this.marca_id = marca_id;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", genero=" + genero
				+ ", precio=" + precio + ", marca_id=" + marca_id + ", product_image=" + product_image + "]";
	}
	
	
	
	

}
