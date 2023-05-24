package com.des.mdm.PFCMDM.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import javax.servlet.ServletContext;

import com.cloudinary.utils.ObjectUtils;
import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Genero;
import com.des.mdm.PFCMDM.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String Home(Authentication auth, Model model) {
		System.out.println(auth.getName());
		model.addAttribute("prods", productService.findFeatured());
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
	
	

	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("title", "NBA STORE");
	}
	

	}
