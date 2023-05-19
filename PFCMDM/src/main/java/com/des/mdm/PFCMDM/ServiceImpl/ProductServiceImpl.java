package com.des.mdm.PFCMDM.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Product;
import com.des.mdm.PFCMDM.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

}
