package All.contorller;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import All.vo.MemberVO;
import member.service.MemberService;



@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "add_person")
	@ResponseBody
	public String add_person(@ModelAttribute MemberVO vo){
//		System.out.println(vo);
		String flag = memberService.insert(vo);
//		System.out.println(flag);
		if(flag!="true") flag = "already used this E-mail";
		return flag;
	} 
	@RequestMapping(value = "login")
	@ResponseBody
	public String login(@ModelAttribute MemberVO vo,HttpSession session,Model model){
		System.out.println(vo);
		String result = memberService.login(vo);
		session.setAttribute("email", vo.getEmail());
		return result;
	}
	
	
}
