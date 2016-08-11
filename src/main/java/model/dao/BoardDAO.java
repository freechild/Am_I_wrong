package model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.vo.BoardVO;


@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	
	// 개수얻기
	public int getCount(int categoryid){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("categoryid", categoryid);
		return session.selectOne("board.getCount",map);
	}
	public int getCount(int categoryid,String search,String searchContent){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("categoryid", categoryid+"");
		map.put("search", search);
		map.put("searchContent", searchContent);
		return session.selectOne("board.getCount",map);
	}
	// 넣기
	public void insert(BoardVO vo){
		session.insert("board.insert",vo);
	}
	// 고치기
	public void update(BoardVO vo){
		session.update("board.update",vo);
	}
	// 조회수 증가하기
	public void hitIncrement(int idx){
		session.update("board.hitIncrement",idx);
	}
	// 지우기
	public void delete(int idx){
		session.delete("board.delete",idx);
	}
	// 1개얻기
	public BoardVO selectByIdx(int idx){
		return session.selectOne("board.selectByIdx",idx);
	}
	// 리스트 얻기
	public List<BoardVO> selectList(int startNo,
			int endNo,int categoryid){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNo",startNo );
		map.put("endNo",endNo );
		map.put("categoryid",categoryid );
		return session.selectList("board.selectList",map);
	}
	// 검색 리스트 얻기
	public List<BoardVO> selectSearch( int startNo,int endNo,
			int categoryid, String search,String searchContent){
		HashMap<String, String> map = new HashMap<String, String> ();
		map.put("startNo",startNo+"" );
		map.put("endNo",endNo+"" );
		map.put("categoryid",categoryid+"" );
		map.put("search", search);
		map.put("searchContent", searchContent);
		return session.selectList("board.selectList",map);
	}

}







