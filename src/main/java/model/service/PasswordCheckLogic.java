package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dao.BoardDAO;
import model.dao.CommentDAO;
import model.vo.BoardVO;
import model.vo.CommentVO;

@Service
public class PasswordCheckLogic {
	
	@Autowired
	private BoardDAO boardDao;
	
	@Autowired
	private CommentDAO commentDao;
	
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
	
	public String passwordCheck (int idx,String pw,int chk){
		String flag = "false";
		System.out.println(idx);
		try {
			CommentVO vo =
					commentDao.selectByIdx(idx);
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
			e.printStackTrace();
			System.out.println("<passwordCheck> error");
		}
		//System.out.println(flag);
		return flag;
	}
}
