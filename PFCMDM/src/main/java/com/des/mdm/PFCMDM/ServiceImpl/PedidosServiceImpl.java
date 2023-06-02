package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.PedidosService;
import com.des.mdm.PFCMDM.model.Pedidos;
import com.des.mdm.PFCMDM.model.User;
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

	@Override
	public List<Pedidos> findAllPedidos() {
		return pedidosrepository.findAll();
	}

	@Override
	public Pedidos findById(int id) {
		Optional<Pedidos> ped =  pedidosrepository.findById(id);
		return ped.get();
	}

	@Override
	public long countByUser(User user) {
		return pedidosrepository.countByUsuario(user);
	}


}
