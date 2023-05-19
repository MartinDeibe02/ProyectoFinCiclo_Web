package com.des.mdm.PFCMDM.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.model.Brand;

public interface BrandService {
	List<Brand> findAllBrands();
}
