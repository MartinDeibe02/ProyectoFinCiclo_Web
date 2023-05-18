package com.des.mdm.PFCMDM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	
	@GetMapping("/men")
	public String products_men() {
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
