package com.des.mdm.PFCMDM.Home;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import javax.servlet.ServletContext;

import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

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
	
	@PostMapping("/test")
	public String test(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        
	    String url = uploadToCloudinary(multipartFile);
	    System.out.println(url);

		return "redirect:/add";
}
	
	
	private String uploadToCloudinary(MultipartFile multipartFile) throws IOException {
	    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
	        "cloud_name", "daolhlyb6",
	        "api_key", "853471969531956",
	        "api_secret", "yQIl1DHYJbh0Gm3td56uD7d66ts",
	        "secure", true));

	    Map<?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
	    return (String) uploadResult.get("url");
	}
	}
