package com.des.mdm.PFCMDM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.mdm.PFCMDM.model.Brand;
import com.des.mdm.PFCMDM.model.User;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	List<Brand> findByNombreContaining(String brand);

}
