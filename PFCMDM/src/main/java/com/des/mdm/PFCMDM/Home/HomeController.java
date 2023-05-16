package com.des.mdm.PFCMDM.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Home() {
		return "homepage";
	}
	
	@GetMapping("/log")
	public String login() {
		return "brands";
	}
	
	@GetMapping("/reg")
	public String register() {
		return "cart";
	}

	@GetMapping("/men")
	public String products_men() {
		return "/products/products_Men";
}
	
	@GetMapping("/detail")
	public String detail() {
		return "/products/detail";
}
	
	@GetMapping("/admin/users")
	public String adminUsers() {
		return "/admin/adminPaneUsers";
}
	
	@GetMapping("/admin/products")
	public String adminProducts() {
		return "/admin/adminPaneUsers";
}
	@GetMapping("/admin/brands")
	public String adminBrands() {
		return "/admin/adminPaneBrands";
}
	
	@GetMapping("/add")
	public String add() {
		return "/admin/addProduct";
}
	
	}
