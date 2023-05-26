package com.des.mdm.PFCMDM.Controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.des.mdm.PFCMDM.Service.BrandService;
import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.Service.UserService;
import com.des.mdm.PFCMDM.model.Brand;
import com.des.mdm.PFCMDM.model.Genero;
import com.des.mdm.PFCMDM.model.Product;

@Controller
public class AdminController {

	@Autowired
	BrandService brandService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/admin/users")
	public String adminUsers(Authentication auth, Model model) {
		model.addAttribute("users", userService.findUsers());
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
	
	@GetMapping("/admin/add")
	public String add(Product producto,Brand brand, Model model) {
		model.addAttribute("generos", Genero.values());
		model.addAttribute("brands",brandService.findAllBrands());
		model.addAttribute("producto", producto);
		model.addAttribute("brand", brand);
		
		
		return "/admin/addProduct";
}
	
	@PostMapping("/saveProd")
	public String saveProd(Product producto,@RequestParam("file") MultipartFile multipartFile, BindingResult result,RedirectAttributes redirectAttributes, Model model) throws IOException {
		if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrió un error: " + error.getDefaultMessage());
            }
            redirectAttributes.addFlashAttribute("error", "Por favor corrija los errores del formulario");
	    } else {
	    	String url = uploadToCloudinary(multipartFile);
		    producto.setProduct_image(url);
	        System.out.println(producto);
	        productService.saveProduct(producto);
	        redirectAttributes.addFlashAttribute("success", "¡El formulario se envió correctamente!");
	    }
        return "redirect:/admin/add";	    

}
	
	
	@PostMapping("/saveBrand")
	public String saveCat(Brand brand) {
		brandService.saveBrand(brand);
        return "redirect:/admin/add";	    
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
