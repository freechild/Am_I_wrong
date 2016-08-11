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


import model.service.BoardService;
import model.service.CategoryService;
import model.service.CommentService;
import model.service.PagingProcess;
import model.vo.BoardVO;
import model.vo.CategoryVO;
import model.vo.CommentVO;
import model.vo.PagingList;


@Controller
public class boardController {
	
	
		
		@Autowired
		private BoardService boardService;
		@Autowired
		private CategoryService categoryService;
		@Autowired
		private CommentService commentService;
		
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
			int categoryId = map.get("categoryId");
			//cid
			
			String search = request.getParameter("search");
			if(search!=null)
				model.addAttribute("search", search);
			
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryId);
			
			PagingList<BoardVO> board =
			boardService.selectList(currentPage, pageSize, blockSize, categoryId);
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
			int categoryId = map.get("categoryId");
			//cid
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryId);
			
			List<CategoryVO>categories =
					categoryService.getCategories();
			
			model.addAttribute("categories", categories);
			
			return "b_write";
		}
	
		@RequestMapping(value = "b_view")
		public String b_view(Model model,@RequestParam("idx") int idx){
			
			BoardVO vo = boardService.selectByIdx(idx);
			model.addAttribute("vo", vo);
			
			List<CommentVO> Clist = commentService.selectList(idx);
			model.addAttribute("clist", Clist);
			
			CategoryVO categories =
					categoryService.getCategories(vo.getCategoryid());
			
			System.out.println(categories);
			
			
			return "b_view";
		}
	
		@RequestMapping(value = "b_writeOk")
		public String b_writeOk(@ModelAttribute BoardVO vo,HttpServletRequest request){
			vo.setIp(request.getRemoteAddr());
			if(vo.getSavefile()==null){
				vo.setSavefile(" ");
				vo.setOrigfile(" ");
			}
			System.out.println(vo);
			boardService.insert(vo);
			
			return "redirect:/board";
		}
		
		
		
}
