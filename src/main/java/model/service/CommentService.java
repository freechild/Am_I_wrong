package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.dao.CommentDAO;
import model.vo.CommentVO;

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
	public List<CommentVO> selectList(int ref){
		List<CommentVO> list = null;
		try {
			list = commentDAO.selectList(ref);
		} catch (Exception e) {
			;
		}
		return list;
	}
	public int update(CommentVO vo){
		int result=0;
		try {
			CommentVO dbvo = commentDAO.selectByIdx(vo.getIdx());
			if(dbvo!=null)
				if(dbvo.getPassword().equals(vo.getPassword()))
					commentDAO.update(dbvo);
				else
					result =1;
			else
				result=2;
		} catch (Exception e) {
			result=3;
		}
		return result;
	}
	public int delete(CommentVO vo){
		int result=0;
		try {
			CommentVO dbvo = commentDAO.selectByIdx(vo.getIdx());
			if(dbvo!=null)
				if(dbvo.getPassword().equals(vo.getPassword()))
					commentDAO.update(dbvo);
				else
					result =1;
			else
				result=2;
		} catch (Exception e) {
			result=3;
		}
		return result;
	}
}
