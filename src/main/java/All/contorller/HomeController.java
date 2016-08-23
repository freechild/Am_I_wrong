package All.contorller;


import java.util.Locale;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		
		return "test/test";
	}
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public String test2( Model model) {
		
		return "test/test2";
	}
	@RequestMapping(value = "test3", method = RequestMethod.GET)
	public String test3(Model model) {
		
		return "test/test3";
	}
	@RequestMapping(value = "test4", method = RequestMethod.GET)
	public String test4(Model model) {
		
		return "test/test4";
	}
	@RequestMapping(value = "test5", method = RequestMethod.GET)
	public String test5(Model model) {
		
		return "test/test5";
	}
	
}
