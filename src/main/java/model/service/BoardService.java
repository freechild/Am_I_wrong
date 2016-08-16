package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.dao.BoardDAO;
import model.dao.CategoryDAO;
import model.dao.CommentDAO;
import model.vo.BoardVO;
import model.vo.PagingList;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardDAO boardDao;
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private CommentDAO commentDAO;
	
	

	
	// 일반리스트
	public PagingList<BoardVO> selectList(int currentPage,int pageSize,int blockSize,int categoryid){
		PagingList<BoardVO> board = null;
		try {
			int categoryCount = categoryDao.getCount();
			if(categoryid < 0 || categoryid > categoryCount) categoryid=0;
			int totalCount = boardDao.getCount(categoryid);
			board = new PagingList<BoardVO>(totalCount, currentPage, pageSize, blockSize);
			board.setList(boardDao.selectList(board.getStartNo(), 
					board.getEndNo(), categoryid));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return board;
	}
	
	// 검색리스트
	public PagingList<BoardVO> 
	selectSearch(int currentPage,int pageSize,int blockSize,
			     int categoryid,String search,String searchContent){
		PagingList<BoardVO> board = null;
		try {
			int categoryCount = categoryDao.getCount();
			if(categoryid < 0 || categoryid > categoryCount) categoryid =0;
			int totalCount = boardDao.getCount(categoryid);
			board = new PagingList<BoardVO>(totalCount, currentPage, pageSize, blockSize);
			board.setList(boardDao.selectSearch(board.getStartNo(),
					board.getEndNo(), categoryid, search, searchContent));
			
		} catch (Exception e) {
			System.out.println("search error");
			e.printStackTrace();
		}
		
		return board;
	}
	
	public int insert(BoardVO vo){
		int result = 0;
		try {
			boardDao.insert(vo);
		} catch (Exception e) {
			result=1;
			e.printStackTrace();
		}		
		
		System.out.println("service : "+result);
		return result;
	}
	
	// 1개읽기
	public BoardVO selectByIdx(int idx){
		BoardVO vo = null;
		
		try {
			vo=boardDao.selectByIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	// 조회수 증가
	public void hitIncrement(int idx){
		try {
			boardDao.hitIncrement(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String passwordCheck (int idx,String pw){
		String flag = "false";
		
		try {
			BoardVO vo =
			boardDao.selectByIdx(idx);
			if(vo==null){
				
				System.out.println("<passwordCheck> vo not exist");
			}
			else if(vo!=null){
				if(!vo.getPw().equals(pw)){	
					System.out.println("<passwordCheck> password not match");
					System.out.println(pw);
					System.out.println(vo.getPw());
					
				}
				else if(vo.getPw().equals(pw)){
					flag="true";
				}
			}
				
		} catch (Exception e) {
			
			System.out.println("<passwordCheck> error");
		}
		//System.out.println(flag);
		return flag;
	}
	
	public void delete(int idx){
		boardDao.delete(idx);
	}
	
	public void update(BoardVO vo){
		int result =0;
		
		try {
			boardDao.update(vo);
			
		} catch (Exception e) {
			result=1;
		}
		
		System.out.println(result);
	}
}










