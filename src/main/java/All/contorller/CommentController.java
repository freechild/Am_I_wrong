package All.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import All.vo.CommentVO;
import board.service.CommentService;
import board.service.ClientCheckLogic;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private ClientCheckLogic clientCheckLogic;
	
	
	@RequestMapping(value ="/b_comment")
	@ResponseBody
	public String b_comment(@ModelAttribute CommentVO vo,HttpServletRequest request){
		
		System.out.println(vo);
		
		commentService.insert(vo);
			
		return "b_view?idx="+vo.getB_ref();
	}

	@RequestMapping(value ="/c_del")
	@ResponseBody
	public String c_delete(@RequestParam("idx") int idx,
			@RequestParam("mem_ref")int mem_ref){
		System.out.println("get in");
		String flag =
		clientCheckLogic.editCheck(idx, mem_ref, 1);
		System.out.println(flag);
		if(flag =="true")
			commentService.delete(idx);
		
		return flag;
	}
}
