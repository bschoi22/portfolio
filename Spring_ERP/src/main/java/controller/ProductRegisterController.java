package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inventory")
public class ProductRegisterController {
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String view() { 
		return "inventory/product";
	}
}
