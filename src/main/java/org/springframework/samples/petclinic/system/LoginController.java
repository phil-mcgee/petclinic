package org.springframework.samples.petclinic.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String renderLoginPage(Model model) {
		return "login";
	}

}
