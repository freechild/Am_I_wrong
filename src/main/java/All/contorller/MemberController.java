package All.contorller;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import All.vo.MemberVO;
import All.vo.MessageVO;
import member.service.MemberService;
import member.service.MessageService;



@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MessageService messageService;
	
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
	
	//add this
	@RequestMapping(value = "searchFriend",produces ="text/html; charset=UTF-8")
	@ResponseBody
	public Object searchFried(@RequestParam("search")String search,@RequestParam("idx")int idx){
		String data =null;
		
		List<MemberVO> list = memberService.friendList(search,idx);
//		System.out.println(list);
		if(list.isEmpty())
			data = "false"; 
		else{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("friendList", list);
			Gson gson = new Gson();
			data = gson.toJson(map);
		}
		System.out.println(data);
		return data;
	}
	
	@RequestMapping(value="addFriend",produces ="text/html; charset=UTF-8")
	@ResponseBody
	public String addFriend(@ModelAttribute MessageVO vo){
		String result =null;
		boolean bool = messageService.insert(vo);
		if(bool==true) 
			result ="메시지를 보냈습니다.";
		else
			result ="이미 등록된 친구입니다.";
		return result;
	}
}
