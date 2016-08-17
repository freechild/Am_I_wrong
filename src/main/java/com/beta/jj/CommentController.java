package com.beta.jj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.CommentService;
import model.service.PasswordCheckLogic;
import model.vo.CommentVO;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private PasswordCheckLogic passwordCheckLogic;
	
	
	@RequestMapping(value ="b_comment")
	@ResponseBody
	public String b_comment(@ModelAttribute CommentVO vo){
		
		commentService.insert(vo);
//		System.out.println(vo);
			
		return "b_view?idx="+vo.getRef();
	}

	@RequestMapping(value ="c_checkPW")
	@ResponseBody
	public String c_checkPW(@RequestParam("pw") String pw,@RequestParam("idx") int idx,
			@RequestParam("b_idx")int b_idx){
		System.out.println(b_idx);
		String bool =
		passwordCheckLogic.passwordCheck(idx, pw, 1);
		
		if(bool=="true" ){
			commentService.delete(idx);
			bool = "b_view?idx="+b_idx;
		}
		
		return bool;
	}
}
