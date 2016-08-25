package All.contorller;
import java.util.HashMap;
import java.util.List;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.google.gson.Gson;

import All.vo.BoardVO;
import All.vo.CategoryVO;

import All.vo.PagingList;
import All.vo.TotalVO;
import board.service.BoardService;
import board.service.CategoryService;
import board.service.CommentService;
import board.service.PagingProcess;
import board.service.ClientCheckLogic;



@Controller
public class BoardController {
	
		
		@Autowired
		private BoardService boardService;
		@Autowired
		private CategoryService categoryService;
		@Autowired	
		private CommentService commentService;
		@Autowired
		private ClientCheckLogic clientCheckLogic;
		
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

	
		@RequestMapping(value = "{email}/board", method = RequestMethod.GET)
		public String board(@PathVariable("email") String email,Model model,HttpServletRequest request) {
			
			
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
			
			PagingList<TotalVO> board =
			boardService.selectList(currentPage, pageSize, blockSize, categoryid);
			List<CategoryVO>categories =
			categoryService.getCategories();
			
			
			//System.out.println(board);
			
			model.addAttribute("board", board);
			model.addAttribute("categories", categories);
			return "board";
		
	}
	
		
		@RequestMapping(value ="{email}/b_write")
		public String b_write(@PathVariable("email") String email,HttpServletRequest request,Model model){
			
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
	
		@RequestMapping(value = "{email}/b_writeOk")
		public String b_writeOk(@PathVariable("email") String email,@ModelAttribute BoardVO vo,HttpServletRequest request){
			vo.setIp(request.getRemoteAddr());
			vo.setMem_ref(Integer.parseInt(String.valueOf( request.getSession().getAttribute("m_idx"))));
			if(vo.getSavefile()==null){
				vo.setSavefile(" ");
				vo.setOrigfile(" ");
			}
			System.out.println(vo);
			boardService.insert(vo);
	
			return "redirect:board";
		}
		
		
		
		@RequestMapping(value = "{email}/b_view")
		public String b_view(@PathVariable("email") String email,Model model,@RequestParam("idx") int idx,HttpServletRequest request){
//			System.out.println(idx);
			TotalVO vo = boardService.selectByIdx(idx);
			System.out.println(vo);
			model.addAttribute("vo", vo);
			
//			boardService.hitIncrement(idx);
			
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
			
			List<TotalVO> Clist = commentService.selectList(idx);
			model.addAttribute("clist", Clist);
//			System.out.println(Clist);
			return "b_view";
		}
		
		@RequestMapping(value ="{email}/b_modi",produces ="text/html; charset=UTF-8")
		@ResponseBody
		public String b_modi(@PathVariable("email") String email,Model model,@RequestParam("idx")int idx,@RequestParam("mem_ref")int mem_ref){
	
			String flag = clientCheckLogic.editCheck(idx, mem_ref);
			
			if(flag == "true"){
				TotalVO vo = boardService.selectByIdx(idx);
				System.out.println(vo);
				flag = "{test':'"+ vo.getContent() +"'}";
				Gson gson = new Gson();
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("title", vo.getTitle());
				map.put("content", vo.getContent());
				flag = gson.toJson(map);
				
			}
			
			return flag;
		}
		
		@RequestMapping(value ="{email}/b_modiView")
		@ResponseBody
		public void b_modiView(@PathVariable("email") String email,
				@ModelAttribute BoardVO vo,HttpServletRequest request){
			
			vo.setIp(request.getRemoteAddr());
			if(vo.getSavefile()==null){
				vo.setSavefile(" ");
				vo.setOrigfile(" ");
			}
			
			System.out.println(vo);
			boardService.update(vo);			
		}
		@RequestMapping(value ="{email}/b_del")
		@ResponseBody
		public String b_delete(@PathVariable("email") String email,
				@RequestParam("idx")int idx,@RequestParam("mem_ref")int mem_ref){
			String flag = clientCheckLogic.editCheck(idx, mem_ref);
			return flag;
		}
		@RequestMapping(value ="{email}/b_delOk")
		@ResponseBody
		public void b_deleteOk(@PathVariable("email") String email,@RequestParam("idx")int idx){
			boardService.delete(idx);
		}
		
		
		@RequestMapping(value ="{email}/b_search")
		public String b_search(@PathVariable("email") String email,Model model,HttpServletRequest request){
			
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
			
			PagingList<TotalVO> board =
			boardService.selectSearch(currentPage, pageSize, blockSize, categoryid, search, searchContent);
			List<CategoryVO>categories =
					categoryService.getCategories();
					
			model.addAttribute("board", board);
			model.addAttribute("categories", categories);
			
			
			
			return "board";
		}
		
		@RequestMapping(value ="{email}/b_category")
		public String b_category(@PathVariable("email") String email,Model model,HttpServletRequest request,@RequestParam("value") int categoryid){
			
			
			
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
			
			PagingList<TotalVO> board =
			boardService.selectList(currentPage, pageSize, blockSize, categoryid);
			
			model.addAttribute("board",board);
			
			List<CategoryVO>categories =
					categoryService.getCategories();
			
			model.addAttribute("categories", categories);
			
			
			return "board";
		}
		
		
}
