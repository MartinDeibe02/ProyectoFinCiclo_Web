package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.Productos_pedidosService;
import com.des.mdm.PFCMDM.model.Pedidos;
import com.des.mdm.PFCMDM.model.Productos_pedidos;
import com.des.mdm.PFCMDM.repository.ProductosPedidoRepository;

@Service
public class ProductosPerdidosServiceImpl implements Productos_pedidosService{

	@Autowired
	ProductosPedidoRepository prodsPedRepository;
	
	@Override
	public void savePedProd(Productos_pedidos prodsPed) {
		prodsPedRepository.save(prodsPed);
	}

	@Override
	public List<Productos_pedidos> findByIdPed(int id) {
		Pedidos ped = new Pedidos();
		ped.setId(id);
		return prodsPedRepository.findByPedido(ped);
	}



}
