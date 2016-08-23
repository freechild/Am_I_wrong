package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import All.vo.BoardVO;
import All.vo.CommentVO;
import All.vo.TotalVO;
import board.dao.CommentDAO;

@Transactional
@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	//=====================================================
	public int getCount(int idx){
		int result = 0;
		try {
			result = commentDAO.getCount(idx);
		} catch (Exception e) {
			result=1;
		}
		return result;
	}
	
	public int insert(CommentVO vo){
		int result=0;
		try {
			commentDAO.insert(vo);
		} catch (Exception e) {
			result=1;
			e.printStackTrace();
//			System.out.println(result);
		}
		return result;
	}
	
	public CommentVO selectByIdx(int idx){
		CommentVO vo = null;
		try {
			vo = commentDAO.selectByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public List<TotalVO> selectList(int ref){
		List<TotalVO> list = null;
		try {
			list = commentDAO.selectList(ref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int update(CommentVO vo){
		int result = 0;
		try{
			commentDAO.update(vo);
		}catch(Exception e){
			result = 1;
		}
		return result;
	}
	public void delete(int idx){
		commentDAO.delete(idx);	
	}
//	
//	public String passwordCheck (int idx,String pw){
//		String flag = "false";
//		
//		try {
//			CommentVO vo = commentDAO.selectByIdx(idx);
//			if(vo==null){
//				
//				System.out.println("<passwordCheck> vo not exist");
//			}
//			else if(vo!=null){
//				if(!vo.getPw().equals(pw)){	
//					System.out.println("<passwordCheck> password not match");
//					System.out.println(pw);
//					System.out.println(vo.getPw());
//					
//				}
//				else if(vo.getPw().equals(pw)){
//					flag="true";
//				}
//			}
//				
//		} catch (Exception e) {
//			
//			System.out.println("<passwordCheck> error");
//		}
//		//System.out.println(flag);
//		return flag;
//	}
}
