package com.des.mdm.PFCMDM.Service;

import java.util.List;

import com.des.mdm.PFCMDM.model.Pedidos;

public interface PedidosService {
	void savePedido(Pedidos pedidos);
	long countPedido();
	List<Pedidos> findAllPedidos();
	Pedidos findById(int id);
	
}
