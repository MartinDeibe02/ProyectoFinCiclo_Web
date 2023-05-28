package com.des.mdm.PFCMDM.Service;

import com.des.mdm.PFCMDM.model.Pedidos;

public interface PedidosService {
	void savePedido(Pedidos pedidos);
	long countPedido();
}
