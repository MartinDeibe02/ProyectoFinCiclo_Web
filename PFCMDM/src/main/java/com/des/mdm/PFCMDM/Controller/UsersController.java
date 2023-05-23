package com.des.mdm.PFCMDM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.des.mdm.PFCMDM.Service.UserService;
import com.des.mdm.PFCMDM.model.Permisos;
import com.des.mdm.PFCMDM.model.User;

@Controller
public class UsersController {

	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login() {
		return  "login";
	}
	
	@GetMapping("/register")
	public String register(User user) {
		return  "register";
	}
	
	@PostMapping("/saveUser")
	public String saveUsers(User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Error: " + error.getDefaultMessage());
			}
			return "redirect:/register";
		}
		user.setContrasena(passwordEncoder.encode(user.getContrasena()));
		user.setEstatus(1);
		
		Permisos permiso = new Permisos();
		permiso.setId(2);
		user.agregarPermiso(permiso);
		userService.saveUser(user);
        redirectAttributes.addFlashAttribute("suc", "¡Registro completado!");

		return  "redirect:/login";
	}
	
	
	@GetMapping("/bcrypt/{value}")
	@ResponseBody
	public String bCrypt(@PathVariable("value") String value) {
		
		String pass = passwordEncoder.encode(value);
		return pass;
	}
	
}
