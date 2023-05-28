package com.des.mdm.PFCMDM.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.PedidosService;
import com.des.mdm.PFCMDM.model.Pedidos;
import com.des.mdm.PFCMDM.repository.PedidosRepository;

@Service
public class PedidosServiceImpl implements PedidosService {

	@Autowired
	PedidosRepository pedidosrepository;
	
	@Override
	public void savePedido(Pedidos pedidos) {
		pedidosrepository.save(pedidos);
	}

	@Override
	public long countPedido() {
		return pedidosrepository.count();
	}

}
