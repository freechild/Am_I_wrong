package model.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.vo.CategoryVO;

@Repository
public class CategoryDAO {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	// 모두 얻기
	public List<CategoryVO> selectList(){
		return session.selectList("category.select");
	}
	// 개수구하기
	public int getCount(){
		return session.selectOne("category.getCount");
	}
}
