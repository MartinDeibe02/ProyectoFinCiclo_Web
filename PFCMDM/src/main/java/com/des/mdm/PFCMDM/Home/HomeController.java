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
	
	@GetMapping("/admin")
	public String admin() {
		return "/admin/adminPane";
	
}
	
	@GetMapping("/add")
	public String add() {
		return "/admin/addProduct";
	
}
	}
