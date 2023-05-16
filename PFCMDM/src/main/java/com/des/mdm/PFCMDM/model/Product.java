package com.des.mdm.PFCMDM.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private double precio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marca_id")
	private Brand marca;
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
		return marca;
	}

	public void setMarca_id(Brand marca) {
		this.marca = marca;
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
				+ ", precio=" + precio + ", marca_id=" + marca + ", product_image=" + product_image + "]";
	}
	
	
	
	

}
