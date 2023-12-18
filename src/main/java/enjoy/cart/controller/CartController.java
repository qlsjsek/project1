package enjoy.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@GetMapping("/cart_main")
	public String cart() {
		String forwardPath = "cart_main";
		return forwardPath;
	}
}
