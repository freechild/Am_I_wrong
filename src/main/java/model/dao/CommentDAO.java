package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.vo.CommentVO;

@Repository
public class CommentDAO {
	@Autowired
	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	// 댓글의 개수 구하기
	public int getCount(int idx){
		return session.selectOne("comment.getCount",idx);
	}
	// 넣기
	public void insert( CommentVO vo){
		session.insert("comment.insert",vo);
	}
	// 고치기
	public void update(CommentVO vo){
		session.update("comment.update",vo);
	}
	// 지우기
	public void delete(int idx){
		session.delete("comment.delete",idx);
	}
	// 1개 가져오기
	public CommentVO selectByIdx(int idx){
		return session.selectOne("comment.selectByIdx",idx);
	}
	// 리스트 가져오기
	public List<CommentVO> selectList(int ref){
		return session.selectList("comment.selectList",ref);
	}
	
}
