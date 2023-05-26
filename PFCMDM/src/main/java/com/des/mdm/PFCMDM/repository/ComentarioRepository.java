package com.des.mdm.PFCMDM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.mdm.PFCMDM.model.Comentarios;
import com.des.mdm.PFCMDM.model.Product;

public interface ComentarioRepository extends JpaRepository<Comentarios, Integer> {
	List<Comentarios> findByProducto(Product producto);
}
