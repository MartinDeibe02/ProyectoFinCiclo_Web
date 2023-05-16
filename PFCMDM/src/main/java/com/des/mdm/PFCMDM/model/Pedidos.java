package com.des.mdm.PFCMDM.model;

import java.util.Date;

public class Pedidos {

		private int id;
		private String numero_de_orden;
		private Date fecha_de_compra;
		private User usuario;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNumero_de_orden() {
			return numero_de_orden;
		}
		public void setNumero_de_orden(String numero_de_orden) {
			this.numero_de_orden = numero_de_orden;
		}
		public Date getFecha_de_compra() {
			return fecha_de_compra;
		}
		public void setFecha_de_compra(Date fecha_de_compra) {
			this.fecha_de_compra = fecha_de_compra;
		}
		public User getUsuario() {
			return usuario;
		}
		public void setUsuario(User usuario) {
			this.usuario = usuario;
		}
		@Override
		public String toString() {
			return "Pedidos [id=" + id + ", numero_de_orden=" + numero_de_orden + ", fecha_de_compra=" + fecha_de_compra
					+ ", usuario=" + usuario + "]";
		}
		
		
}
