package enjoy.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/user_login_form")
	public String userLogin() {
		String forwardPath = "user_login_form";
		return forwardPath;
	}
	@GetMapping("/user_write_form")
	public String userWrite() {
		String forwardPath = "user_write_form";
		return forwardPath;
	}
	@GetMapping("/user_find_id_form")
	public String userFindId() {
		String forwardPath = "user_find_id_form";
		return forwardPath;
	}
	@GetMapping("/user_find_pw_form")
	public String userFindPw() {
		String forwardPath = "user_find_pw_form";
		return forwardPath;
	}

}
