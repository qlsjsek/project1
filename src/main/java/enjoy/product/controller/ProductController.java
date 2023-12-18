package enjoy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	@GetMapping("/product_detail")
	public String product_detail() {
		String forwardPath = "product_detail";
		return forwardPath;
	}
}
