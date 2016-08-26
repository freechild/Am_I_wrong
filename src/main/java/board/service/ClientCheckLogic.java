package board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import All.vo.CommentVO;
import All.vo.TotalVO;
import board.dao.BoardDAO;
import board.dao.CommentDAO;

@Service
public class ClientCheckLogic {
	
	@Autowired
	private BoardDAO boardDao;
	
	@Autowired
	private CommentDAO commentDao;
	
	public String editCheck(int idx,int mem_ref){
		String flag ="null";
		
		try {
			TotalVO vo = boardDao.selectByIdx(idx);
			if(vo == null){
				flag = "false";
			}
			else{
				if(vo.getMem_ref() != mem_ref)
					flag = "false";
				else if(vo.getMem_ref() == mem_ref)
					flag = "true";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	public String editCheck(int idx,int mem_ref,int i){
		String flag ="null";
		
		try {
			CommentVO vo = commentDao.selectByIdx(idx);
			if(vo == null){
				flag = "false";
			}
			else{
				if(vo.getMem_ref() != mem_ref)
					flag = "false";
				else if(vo.getMem_ref() == mem_ref)
					flag = "true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
