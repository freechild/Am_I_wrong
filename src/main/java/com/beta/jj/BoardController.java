package com.beta.jj;
import java.util.HashMap;
import java.util.List;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.BoardService;
import model.service.CategoryService;
import model.service.CommentService;
import model.service.PagingProcess;
import model.service.PasswordCheckLogic;
import model.vo.BoardVO;
import model.vo.CategoryVO;
import model.vo.CommentVO;
import model.vo.PagingList;


@Controller
public class BoardController {
	
	
		
		@Autowired
		private BoardService boardService;
		@Autowired
		private CategoryService categoryService;
		@Autowired	
		private CommentService commentService;
		@Autowired
		private PasswordCheckLogic passwordCheckLogic;
		
		public BoardService getBoardService() {
			return boardService;
		}

		public void setBoardService(BoardService boardService) {
			this.boardService = boardService;
		}

		public CategoryService getCategoryService() {
			return categoryService;
		}

		public void setCategoryService(CategoryService categoryService) {
			this.categoryService = categoryService;
		}

		public CommentService getCommentService() {
			return commentService;
		}

		public void setCommentService(CommentService commentService) {
			this.commentService = commentService;
		}
		
		@Autowired
		private PagingProcess pagingProcess; 

		
	
		@RequestMapping(value = {"board"}, method = RequestMethod.GET)
		public String board(Model model,HttpServletRequest request) {
			
			
			HashMap<String, Integer> map =pagingProcess.pagingProcess(request);
			
			
			int currentPage = map.get("currentPage");
			//p
			int pageSize = map.get("pageSize");
			//s
			int blockSize = map.get("blockSize");
			//b
			int categoryid = map.get("categoryid");
			//cid
			
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryid);
			
			PagingList<BoardVO> board =
			boardService.selectList(currentPage, pageSize, blockSize, categoryid);
			List<CategoryVO>categories =
			categoryService.getCategories();
			
			
			
			
			model.addAttribute("board", board);
			model.addAttribute("categories", categories);
			return "board";
		
	}
	
		
		@RequestMapping(value ="b_write")
		public String b_write(HttpServletRequest request,Model model){
			
			HashMap<String, Integer> map =pagingProcess.pagingProcess(request);
			
			
			int currentPage = map.get("currentPage");
			//p
			int pageSize = map.get("pageSize");
			//s
			int blockSize = map.get("blockSize");
			//b
			int categoryid = map.get("categoryid");
			//cid
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryid);
			
			List<CategoryVO>categories =
					categoryService.getCategories();
			
			model.addAttribute("categories", categories);
						
			return "b_write";
		}
	
		@RequestMapping(value = "b_view")
		public String b_view(Model model,@RequestParam("idx") int idx,HttpServletRequest request){
			
			BoardVO vo = boardService.selectByIdx(idx);
			model.addAttribute("vo", vo);
			
			boardService.hitIncrement(idx);
			
			HashMap<String, Integer> map =pagingProcess.pagingProcess(request);
			
			int currentPage = map.get("currentPage");
			//p
			int pageSize = map.get("pageSize");
			//s
			int blockSize = map.get("blockSize");
			//b
			int categoryid = map.get("categoryid");
			//cid
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryid);
			
			List<CommentVO> Clist = commentService.selectList(idx);
			model.addAttribute("clist", Clist);
//			System.out.println(Clist);
			return "b_view";
		}
	
		@RequestMapping(value = "b_writeOk")
		public String b_writeOk(@ModelAttribute BoardVO vo,HttpServletRequest request){
			vo.setIp(request.getRemoteAddr());
			if(vo.getSavefile()==null){
				vo.setSavefile(" ");
				vo.setOrigfile(" ");
			}
//			System.out.println(vo);
			boardService.insert(vo);
			
			return "redirect:/board";
		}
		
	
		@RequestMapping(value = "b_checkPW")
		@ResponseBody
		public String b_checkPW(Model model,@RequestParam("idx") int idx,@RequestParam("pw")String pw,@RequestParam("whichBtn")String whichBtn){
					
//			System.out.println(idx);
//			System.out.println(pw);
//			System.out.println(whichButton);
			
			String bool = 
			passwordCheckLogic.passwordCheck(idx, pw);
			
			if(bool=="true"){
				System.out.println("get in the source");
				if(whichBtn.equals("b_del")){
					System.out.println("pw is right! delete this");	
					boardService.delete(idx);
					bool = "board";
				}
				if(whichBtn.equals("b_modi")){
					System.out.println("pw is right! modity this");	
					bool = "b_modi?modi=1&idx="+idx;
				}
				
			}
			
			return bool;
		}
		
		
		@RequestMapping(value ="b_modi")
		public String b_modi(Model model,@RequestParam int idx,@RequestParam int modi,HttpServletRequest request){
			
			BoardVO vo =boardService.selectByIdx(idx);
			//System.out.println(vo);
			//System.out.println(modi);
			
			b_write(request, model);
			
			model.addAttribute("vo",vo);
			model.addAttribute("modi", modi);
			
			return "b_write";
		}
		
		@RequestMapping(value ="b_modiView")
		public String b_modiView(Model model,@RequestParam int idx,@RequestParam int modi,
				@ModelAttribute BoardVO vo,HttpServletRequest request){
			
			vo.setIp(request.getRemoteAddr());
			if(vo.getSavefile()==null){
				vo.setSavefile(" ");
				vo.setOrigfile(" ");
			}
			//System.out.println(vo);
			boardService.update(vo);
			b_view(model, idx, request);
					
			return "b_view";
		}
		
		
		@RequestMapping(value ="b_search")
		public String b_search(Model model,HttpServletRequest request){
			
			HashMap<String, Integer> map =pagingProcess.pagingProcess(request);
			
			
			int currentPage = map.get("currentPage");
			//p
			int pageSize = map.get("pageSize");
			//s
			int blockSize = map.get("blockSize");
			//b
			int categoryid = map.get("categoryid");
			//cid
			
			
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryid);
			
			String search= null;
			try{
				search =request.getParameter("search");
			}catch(Exception e){}
			String searchContent = null;
			try{
				searchContent = request.getParameter("searchContent");
			}catch(Exception e){}
			
			PagingList<BoardVO> board =
			boardService.selectSearch(currentPage, pageSize, blockSize, categoryid, search, searchContent);
			List<CategoryVO>categories =
					categoryService.getCategories();
					
			model.addAttribute("board", board);
			model.addAttribute("categories", categories);
			
			
			
			return "board";
		}
		
		@RequestMapping(value ="b_category")
		public String b_category(Model model,HttpServletRequest request,@RequestParam("value") int categoryid){
			
			
			
			HashMap<String, Integer> map =pagingProcess.pagingProcess(request);
			
			
			int currentPage = map.get("currentPage");
			//p
			int pageSize = map.get("pageSize");
			//s
			int blockSize = map.get("blockSize");
			//b
			
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryid);
			
			PagingList<BoardVO> board =
			boardService.selectList(currentPage, pageSize, blockSize, categoryid);
			
			model.addAttribute("board",board);
			
			List<CategoryVO>categories =
					categoryService.getCategories();
			
			model.addAttribute("categories", categories);
			
			
			return "board";
		}
		
		
}
