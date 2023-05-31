package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.BrandService;
import com.des.mdm.PFCMDM.model.Brand;
import com.des.mdm.PFCMDM.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	BrandRepository brandRepository;

	@Override
	public List<Brand> findAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public void saveBrand(Brand brand) {
		brandRepository.save(brand);
	}

	@Override
	public long countBrands() {
		return brandRepository.count();
	}

	@Override
	public Brand findById(int id) {
		Optional<Brand> brandOp = brandRepository.findById(id);
		
		if(brandOp.isPresent()) {
			return brandOp.get();
		}
		return null;
	}

}
