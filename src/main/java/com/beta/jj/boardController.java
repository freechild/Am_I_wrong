package com.beta.jj;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.BoardService;
import model.service.CategoryService;
import model.service.CommentService;
import model.vo.BoardVO;
import model.vo.CategoryVO;
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
		
		int currentPage;
		//p
		int pageSize;
		//s
		int blockSize;
		//b
		int categoryId;
		//cid
		@RequestMapping(value = {"board"}, method = RequestMethod.GET)
		public String board(Model model,HttpServletRequest request) {
			
			
			if(request.getParameter("p")==null)
				currentPage=1;
			else
				currentPage = Integer.parseInt( request.getParameter("p"));
			
			if(request.getParameter("s")==null)
				pageSize=5;
			else{
				pageSize = Integer.parseInt( request.getParameter("s"));
				if (pageSize <= 5)
					pageSize = 5;
			}
			
			if(request.getParameter("b")==null)
				blockSize=5;
			else{
				blockSize = Integer.parseInt( request.getParameter("b"));
				if (blockSize <= 5)
					blockSize = 5;
			}
			
			if(request.getParameter("cid")==null)
				categoryId=0;
			else{
				categoryId = Integer.parseInt( request.getParameter("cid"));
				if (categoryId <= 5 && categoryId > 0)
					categoryId = 0;
			}
			String search = request.getParameter("search");
			
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryId);
			
			PagingList<BoardVO> board =
			boardService.selectList(currentPage, pageSize, blockSize, categoryId);
			List<CategoryVO>categories =
			categoryService.getCategories();
			if(search!=null)
				model.addAttribute("search", search);
			
			model.addAttribute("board", board);
			model.addAttribute("categories", categories);
			return "board";
		
	}
	
		
		@RequestMapping(value ="b_write")
		public String b_write(HttpServletRequest request,Model model){
			
			if(request.getParameter("p")==null)
				currentPage=1;
			else
				currentPage = Integer.parseInt( request.getParameter("p"));
			
			if(request.getParameter("s")==null)
				pageSize=5;
			else{
				pageSize = Integer.parseInt( request.getParameter("s"));
				if (pageSize <= 5)
					pageSize = 5;
			}
			
			if(request.getParameter("b")==null)
				blockSize=5;
			else{
				blockSize = Integer.parseInt( request.getParameter("b"));
				if (blockSize <= 5)
					blockSize = 5;
			}
			
			if(request.getParameter("cid")==null)
				categoryId=0;
			else{
				categoryId = Integer.parseInt( request.getParameter("cid"));
				if (categoryId <= 5 && categoryId > 0)
					categoryId = 0;
			}
			
			List<CategoryVO>categories =
					categoryService.getCategories();
			
			model.addAttribute("p", currentPage);
			model.addAttribute("s", pageSize);
			model.addAttribute("b", blockSize);
			model.addAttribute("cid", categoryId);
			model.addAttribute("categories", categories);
			
			return "b_write";
		}
	
	
}
