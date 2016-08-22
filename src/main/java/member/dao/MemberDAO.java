package member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import All.vo.MemberVO;

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
}
