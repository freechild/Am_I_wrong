package com.beta.jj;


import java.util.Locale;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","main"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		
		return "test";
	}
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public String test2( Model model) {
		
		return "test2";
	}
	@RequestMapping(value = "test3", method = RequestMethod.GET)
	public String test3(Model model) {
		
		return "test3";
	}
	
}
