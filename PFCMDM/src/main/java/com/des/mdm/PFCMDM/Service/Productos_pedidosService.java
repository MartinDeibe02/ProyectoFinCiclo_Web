package com.des.mdm.PFCMDM.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.mdm.PFCMDM.model.Productos_pedidos;

public interface Productos_pedidosService{
	void savePedProd(Productos_pedidos prodsPed);
	List<Productos_pedidos> findByIdPed(int id);
}
