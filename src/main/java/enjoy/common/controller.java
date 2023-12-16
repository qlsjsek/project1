package enjoy.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class controller {
	@GetMapping("/common_header")
	public String header() {
		String forwardPath = "common_header";
		return forwardPath;
	}
	@GetMapping("/index")
	public String index() {
		String forwardPath = "index";
		return forwardPath;
	}
}
