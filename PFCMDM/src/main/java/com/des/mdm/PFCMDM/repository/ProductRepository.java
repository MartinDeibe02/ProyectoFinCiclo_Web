package com.des.mdm.PFCMDM.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.des.mdm.PFCMDM.model.Brand;
import com.des.mdm.PFCMDM.model.Genero;
import com.des.mdm.PFCMDM.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Page<Product> findByGenero(Genero genero, Pageable pageable);
	List<Product> findByFeatured(int featured);
	Product findByNombre(String nombre);
	long countByMarca(Brand name);
}
