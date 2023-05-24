package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Genero;
import com.des.mdm.PFCMDM.model.Product;
import com.des.mdm.PFCMDM.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> findProds() {
		return productRepository.findAll();
	}
	
    @Override
    public Page<Product> paginacion(int pagina, int tamanoPagina) {
        Pageable pageable = PageRequest.of(pagina, tamanoPagina);
        return productRepository.findAll(pageable);
    }


	@Override
	public Page<Product> findProdsWoman(int pagina, int tamanoPagina) {
	    Genero genero = Genero.Mujer;

	    Pageable pageable = PageRequest.of(pagina, tamanoPagina);
	    return productRepository.findByGenero(genero, pageable);
	    }

	@Override
	public Page<Product> findProdsMen(int pagina, int tamanoPagina) {
	    Genero genero = Genero.Hombre;

	    Pageable pageable = PageRequest.of(pagina, tamanoPagina);
	    return productRepository.findByGenero(genero, pageable);
	}



}
