package member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import All.vo.MemberVO;
import All.vo.TotalVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession session;
	
	public void insert(MemberVO vo){
		 session.insert("member.insert",vo);
	}
	public int overlap(String email){
		return session.selectOne("member.overlap",email);
	}
	public MemberVO selectByone(String email){
		return session.selectOne("member.selectByOne",email);
	}
	public List<MemberVO> searchFriend(String search,int idx){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("search", search);
		map.put("idx",idx+"");
		return session.selectList("member.searchFriend",map);
	}
	public TotalVO selectByIdx(int idx){
		return session.selectOne("member.selectByIdx",idx);
	}
	public void add_friend(int idx,String friendList){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("idx", idx+"");
		map.put("friendList", friendList);
		session.update("member.add_friend",map);
	} 
	
}
