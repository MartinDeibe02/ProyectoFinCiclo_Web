package com.des.mdm.PFCMDM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;

	
	@GetMapping("/men")
	public String products_men(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "9") int tamanoPagina,
            Model model) {
		Page<Product> productosPaginados = productService.paginacion(page, tamanoPagina);

		model.addAttribute("productos", productosPaginados.getContent());
		model.addAttribute("actualPage", page);
		model.addAttribute("totalPage", productosPaginados.getTotalPages());

		return "/products/products_Men";
}
	
	@GetMapping("/woman")
	public String products_woman() {
		return "/products/products_Women";
}
	
	@GetMapping("/detail")
	public String detail() {
		return "/products/detail";
}
	
}
