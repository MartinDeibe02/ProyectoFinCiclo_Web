package com.des.mdm.PFCMDM.model;

public class ProductoPedidoDTO {
    private int id;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private int totalPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double d) {
		this.precio = d;
	}
	
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "ProductoPedidoDTO [id=" + id + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", totalPrice=" + totalPrice + "]";
	}

	
    
    
    
   
}
