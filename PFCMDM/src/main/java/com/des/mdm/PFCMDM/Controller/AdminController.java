package com.des.mdm.PFCMDM.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.des.mdm.PFCMDM.Service.BrandService;
import com.des.mdm.PFCMDM.Service.PedidosService;
import com.des.mdm.PFCMDM.Service.PermisosService;
import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.Service.UserService;
import com.des.mdm.PFCMDM.model.Brand;
import com.des.mdm.PFCMDM.model.Genero;
import com.des.mdm.PFCMDM.model.Permisos;
import com.des.mdm.PFCMDM.model.Product;
import com.des.mdm.PFCMDM.model.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	BrandService brandService;

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@Autowired
	PedidosService pedidoService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	PermisosService permisoService;

	@GetMapping("/users")
	public String adminUsers(Authentication auth, Model model) {
		model.addAttribute("users", userService.findUsers());
		return "/admin/adminPaneUsers";
	}

	@PostMapping("/saveUser")
	public String saveUserAdmin(User user, @RequestParam(value = "admin", defaultValue = "false") boolean admin,
			RedirectAttributes redirectAttributes, BindingResult result) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrió un error: " + error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("error", "Por favor corrija los errores del formulario");
		} else {
			if(user.getId()==null) {
				if(admin) {
					Permisos permiso = new Permisos();
					permiso.setId(1);
					user.agregarPermiso(permiso);
					user.setContrasena(passwordEncoder.encode(user.getContrasena()));
					user.setEstatus(1);
				}else {
					Permisos permiso = new Permisos();
					permiso.setId(2);
					user.agregarPermiso(permiso);
					user.setContrasena(passwordEncoder.encode(user.getContrasena()));
					user.setEstatus(1);
				}
			
			}else {
				if(admin) {
					
					Permisos adm = permisoService.findById(1);
					user.agregarPermiso(adm);
					
					
				}else {
					user.getPermisos().clear();
					Permisos adm = permisoService.findById(2);
					user.agregarPermiso(adm);
				}
			}
			
			System.out.println(user);
			userService.saveUser(user);
		redirectAttributes.addFlashAttribute("success", "¡El formulario se envió correctamente!");

			
		}
		return "redirect:/admin/addUser";
	}
	
	@GetMapping("/editUser/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		boolean isAdmin = false;
		for (Permisos permiso : user.getPermisos()) {
		    if ("ADMIN".equals(permiso.getPermiso())) {
		        isAdmin = true;
		        break; 
		    }
		}

		model.addAttribute("admin", isAdmin);
		return "/admin/addUser";
	}
	

	@GetMapping("/products")
	public String adminProducts() {
		return "/admin/adminPaneUsers";
	}

	@GetMapping("/brands")
	public String adminBrands() {
		return "/admin/adminPaneBrands";
	}

	@GetMapping("/addUser")
	public String addUser(User user, Model model) {
		return "/admin/addUser";
	}

	@GetMapping("/addProduct")
	public String addProduct(Product producto, Brand brand, Model model) {
		model.addAttribute("generos", Genero.values());
		model.addAttribute("brands", brandService.findAllBrands());
		model.addAttribute("producto", producto);
		model.addAttribute("brand", brand);

		return "/admin/addProduct";
	}

	@GetMapping("/switchStatus/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		User user = userService.findById(id);
		if (user.getEstatus() == 1) {
			user.setEstatus(0);
		} else {
			user.setEstatus(1);
		}
		userService.saveUser(user);

		return "redirect:/admin/users";
	}

	@PostMapping("/saveProd")
	public String saveProd(Product producto, @RequestParam("file") MultipartFile multipartFile, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) throws IOException {
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
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "daolhlyb6", "api_key",
				"853471969531956", "api_secret", "yQIl1DHYJbh0Gm3td56uD7d66ts", "secure", true));

		Map<?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
		return (String) uploadResult.get("url");
	}

	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("countUser", userService.countUsers());
		model.addAttribute("countProduct", productService.countProds());
		model.addAttribute("countBrand", brandService.countBrands());
		model.addAttribute("countPedidos", pedidoService.countPedido());

		Date fechaActual = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String fechaFormateada = dateFormat.format(fechaActual);
		model.addAttribute("updated", fechaFormateada);
	}
}
