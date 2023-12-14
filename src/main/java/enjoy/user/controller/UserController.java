package enjoy.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/user_login")
	public String userLogin() {
		String forwardPath = "user_login";
		return forwardPath;
	}
	@GetMapping("/common_header")
	public String header() {
		String forwardPath = "common_header";
		return forwardPath;
	}
}
