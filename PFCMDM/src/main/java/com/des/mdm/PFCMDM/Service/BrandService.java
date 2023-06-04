package com.des.mdm.PFCMDM.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.model.Brand;
import com.des.mdm.PFCMDM.model.User;

public interface BrandService {
	List<Brand> findAllBrands();
	void saveBrand(Brand brand);
	long countBrands();
	Brand findById(int id);
	void deleteBrand(int id);
	List<Brand> findNombreContaining(String example);

}
