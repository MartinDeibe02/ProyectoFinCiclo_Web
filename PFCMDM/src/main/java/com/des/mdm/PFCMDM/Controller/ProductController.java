package com.des.mdm.PFCMDM.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.des.mdm.PFCMDM.Service.ComentarioService;
import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Comentarios;
import com.des.mdm.PFCMDM.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ComentarioService comentarioService;

	
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
	
		@GetMapping("/detail/{name}")
		public String detail(HttpServletRequest request, Model model, @PathVariable("name") String name,
				Comentarios comentarios, RedirectAttributes redirectAttributes, Authentication authentication) {
			
			Product prod = productService.findByName(name);
			
			
			if(!(prod == null)) {
				model.addAttribute("product", prod);
			    model.addAttribute("title", "DETAIL");
			    model.addAttribute("usuario", authentication.getName());
			    model.addAttribute("comentList", comentarioService.findComentarios_Prod(prod));
	
	
			}else {
				return "error";
			}
			
			
		    String currentUrl = request.getRequestURI() + "?" + request.getQueryString();
		    model.addAttribute("currentUrl", currentUrl);
			return "/products/detail";
	}
		
		@PostMapping("/saveComent")
		public String saveComent(@RequestParam("nombre") String prodName, Authentication authentication
				, @RequestParam("comentario") String comentario) {
			
			
			Comentarios coment = new Comentarios();
			Product prod = productService.findByName(prodName);
			coment.setUsuario(authentication.getName());
			coment.setProducto(prod);
			coment.setComentario(comentario);
			comentarioService.saveComent(coment);
			
	        
			return "redirect:/detail/" + prodName;
	        
		    
		}
		
	

	
	
	
}
