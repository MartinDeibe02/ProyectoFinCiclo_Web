package com.des.mdm.PFCMDM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

	@GetMapping("/login")
	public String login() {
		return  "login";
	}
}
