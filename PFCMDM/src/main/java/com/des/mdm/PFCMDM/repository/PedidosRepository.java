package com.des.mdm.PFCMDM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.mdm.PFCMDM.model.Pedidos;
import com.des.mdm.PFCMDM.model.User;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
	long countByUsuario(User usuario);
}
