package com.des.mdm.PFCMDM.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.des.mdm.PFCMDM.model.Brand;
import com.des.mdm.PFCMDM.model.Product;
import com.des.mdm.PFCMDM.model.User;

public interface ProductService {
	void saveProduct(Product product);
	List<Product> findProds();
	Page<Product> findProdsMen(int pagina, int tamanoPagina);
	Page<Product> findProdsWoman(int pagina, int tamanoPagina);
	Page<Product> paginacion(int pagina, int tamanoPagina);
	List<Product> findFeatured();
	Product findByName(String name);
	Product findById(int id);
	long countProds();
	long countByMarca(Brand marca);
	void deleteProd(int prod);
	List<Product> findNombreContaining(String prod);

}
