package com.des.mdm.PFCMDM.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Home() {
		return "homepage";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/reg")
	public String register() {
		return "register";
	}

	@GetMapping("/men")
	public String products_men() {
		return "/products/products_Men";
	
}
	}
