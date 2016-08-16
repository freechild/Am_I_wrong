package com.beta.jj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.CommentService;
import model.vo.CommentVO;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value ="b_comment")
	@ResponseBody
	public String b_comment(@ModelAttribute CommentVO vo){
		
		commentService.insert(vo);
//		System.out.println(vo);
			
		return "b_view?idx="+vo.getRef();
	}
}
