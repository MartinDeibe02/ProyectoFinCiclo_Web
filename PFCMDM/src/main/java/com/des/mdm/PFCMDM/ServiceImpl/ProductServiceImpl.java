package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Brand;
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

	@Override
	public List<Product> findFeatured() {
		
		List<Product> featuredList = productRepository.findByFeatured(1);
		List<Product> productList = productRepository.findAll();
		
		if(featuredList.isEmpty()) {
			Collections.shuffle(productList);
		    List<Product> randomProducts = featuredList.subList(0, Math.min(productList.size(), 4));
			return randomProducts;
		}else {
		    Collections.shuffle(featuredList);
		    List<Product> randomProducts = featuredList.subList(0, Math.min(featuredList.size(), 4));

			return randomProducts;
		}
		
	}

	@Override
	public Product findByName(String name) {
		Optional<Product> prod = Optional.ofNullable(productRepository.findByNombre(name));
		
		if(prod.isPresent()) {
			Product getProd = prod.get();
			return getProd;
		}else {
			return null;
		}

	}

	@Override
	public Product findById(int id) {
		Optional<Product> prod = productRepository.findById(id);
		
		if(prod.isPresent()) {
			Product getProd = prod.get();
			return getProd;
		}else {
			return null;
		}
	}

	@Override
	public long countProds() {
		return productRepository.count();
	}

	@Override
	public long countByMarca(Brand marca) {
		return productRepository.countByMarca(marca);
	}

	@Override
	public void deleteProd(int prod) {
		productRepository.deleteById(prod);
	}

	@Override
	public List<Product> findNombreContaining(String prod) {
		return productRepository.findByNombreContaining(prod);
	}



}
