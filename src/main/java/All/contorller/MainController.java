package All.contorller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import All.vo.TotalVO;
import main.event.EventProess;
import member.service.MemberService;
import member.service.MessageService;

@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private EventProess eventProess;
	
	
	@RequestMapping(value = {"/","main"}, method = RequestMethod.GET)
	public String home() {
		
		return "front";
	}
	@RequestMapping(value="{email}/main", produces={"text/html"})
	public String get_in(@PathVariable("email") String email,HttpSession session,
			Model model,HttpServletRequest request){
		
		if(session.getAttribute("email")==null)
			return "front";
		int m_idx=memberService.selectByIdx(email);
		HashMap<String, String> map = eventProess.eventProress(request);
	
		
		session.setAttribute("m_idx",m_idx );
		model.addAttribute("date", map);
		return "main";
	}
	
	@RequestMapping(value="/calendar")
	@ResponseBody
	public String calendar(HttpServletRequest request){
		HashMap<String, String> map = eventProess.eventProress(request);
		Gson gson = new Gson();
		String date = gson.toJson(map);
		System.out.println(date);
		return date;
	}
	
	
	
	
	
}
