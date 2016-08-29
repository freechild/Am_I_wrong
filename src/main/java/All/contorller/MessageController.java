package All.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import All.vo.TotalVO;
import member.service.MemberService;
import member.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="{email}/invites", produces={"text/html"})
	public String invites(@PathVariable("email") String email,HttpSession session,
			Model model,HttpServletRequest request){
		return "friendList/invites";
	}
	@RequestMapping(value="{email}/message", produces={"text/html"})
	public String Message(@PathVariable("email") String email,HttpSession session,
			Model model,HttpServletRequest request){
		Object obj = session.getAttribute("m_idx");
		int both_idx = Integer.parseInt( obj.toString());
		System.out.println(both_idx);
		List<TotalVO> list = messageService.selectList(both_idx);
		System.out.println(list);
		int listCount = messageService.getCount(both_idx);
		
		model.addAttribute("listCount", listCount);
		model.addAttribute("messageList", list);
		
		return "friendList/message";
	}
	@RequestMapping(value="/msgDetail",produces ="text/html; charset=UTF-8")
	@ResponseBody
	public String msgDetail(@RequestParam("idx")int idx){
		TotalVO vo = messageService.selectByIdx(idx);
		Gson gson = new Gson();
		String result = gson.toJson(vo);
		return result;
	}
	@RequestMapping(value="/status_friend",produces ="text/html; charset=UTF-8")
	@ResponseBody
	public void status_friend(@RequestParam("status")String status,@RequestParam("idx")int idx){
		System.out.println(status);
		if(status.equals("add")){	
			TotalVO vo = messageService.selectByIdx(idx);
			System.out.println(vo);
			memberService.add_friend(vo.getRecipient_idx(), vo.getSender_idx());
			memberService.add_friend(vo.getSender_idx(), vo.getRecipient_idx());
			messageService.delete(idx);
		}
		else{
			messageService.delete(idx);
		}
	}
}
