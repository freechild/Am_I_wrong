package All.contorller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = {"/","main"}, method = RequestMethod.GET)
	public String home() {
		
		return "front";
	}
	@RequestMapping(value="{email}/main", produces={"text/html"})
	public String method7(@PathVariable("email") String email,HttpSession session){
		System.out.println(session.getAttribute("email"));
		if(session.getAttribute("email")==null)
			return "front";
		int m_idx=memberService.selectByIdx(email);
		session.setAttribute("m_idx",m_idx );
		return "main";
		
	}
}
