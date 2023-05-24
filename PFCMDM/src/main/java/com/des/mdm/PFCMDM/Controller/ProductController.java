package com.des.mdm.PFCMDM.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;

	
	@GetMapping("/man")
	public String products_men(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "9") int tamanoPagina,
            Model model, HttpServletRequest request) {
		Page<Product> productosPaginados = productService.findProdsMen(page, tamanoPagina);

		model.addAttribute("productos", productosPaginados.getContent());
		model.addAttribute("actualPage", page);
		model.addAttribute("totalPage", productosPaginados.getTotalPages());
		

		
		model.addAttribute("title", "MEN");


		return "/products/products";
}
	
	@GetMapping("/woman")
	public String products_woman(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "9") int tamanoPagina,
            Model model, HttpServletRequest request) {
		Page<Product> productosPaginados = productService.findProdsWoman(page, tamanoPagina);

		model.addAttribute("productos", productosPaginados.getContent());
		model.addAttribute("actualPage", page);
		model.addAttribute("totalPage", productosPaginados.getTotalPages());
		model.addAttribute("title", "MEN");

	
		
		model.addAttribute("title", "Woman");

		return "/products/products";
}
	
	
	@GetMapping("/products")
	public String products(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "9") int tamanoPagina,
            Model model, HttpServletRequest request) {
		Page<Product> productosPaginados = productService.paginacion(page, tamanoPagina);

		model.addAttribute("productos", productosPaginados.getContent());
		model.addAttribute("actualPage", page);
		model.addAttribute("totalPage", productosPaginados.getTotalPages());
		model.addAttribute("title", "MEN");


		
		model.addAttribute("title", "PRODUCTS");

		return "/products/products";
}
	
	@GetMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
	    String currentUrl = request.getRequestURI() + "?" + request.getQueryString();
	    model.addAttribute("currentUrl", currentUrl);
		return "/products/detail";
}
	
	
	
}
