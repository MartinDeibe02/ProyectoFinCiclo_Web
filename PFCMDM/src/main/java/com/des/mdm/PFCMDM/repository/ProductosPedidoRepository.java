package com.des.mdm.PFCMDM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.mdm.PFCMDM.model.Pedidos;
import com.des.mdm.PFCMDM.model.Productos_pedidos;

public interface ProductosPedidoRepository extends JpaRepository<Productos_pedidos, Integer>{
	List<Productos_pedidos> findByPedido(Pedidos pedido);
}
