package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import All.vo.CategoryVO;
import board.dao.CategoryDAO;

@Transactional
@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	//=====================================================
	public List<CategoryVO> getCategories(){
		List<CategoryVO> categories = null;
		try {
			categories = categoryDao.selectList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	public CategoryVO getCategories(int categoryid){
		CategoryVO vo = null;
		try {
			int idx = categoryid;
			vo = categoryDao.selectList(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}
