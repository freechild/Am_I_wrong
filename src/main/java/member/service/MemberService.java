package member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import All.vo.MemberVO;
import All.vo.TotalVO;
import member.dao.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public String insert(MemberVO vo){
		String flag ="false";
		try {
			int result = overlap(vo.getEmail());
			if(result == 0){
				flag = "true";
				memberDAO.insert(vo);					
			}
			System.out.println("id overlap = "+flag);
		} catch (Exception e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
		return flag;
	}
	
	private int overlap(String email){
		int result =0;
		try {
			result = memberDAO.overlap(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String login(MemberVO vo){
		String result = null;
		try {
			MemberVO mVo = memberDAO.selectByone(vo.getEmail());
			if(mVo==null) result = "E-mail isn't exist!";
			else{
				if(mVo.getPw().equals(vo.getPw()))
					result = "true";
				else
					result = "Password is wrong number! try again";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int selectByIdx(String email){
		int result =0;
		try {
			result = memberDAO.selectByone(email).getIdx();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return result;
	}
	public List<MemberVO> friendList(String search,int idx){
		List<MemberVO> list = null;
		try {
			System.out.println(search);
			list = memberDAO.searchFriend(search,idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void add_friend(int idx,int friendList){
		try {
			TotalVO vo = memberDAO.selectByIdx(idx);
			System.out.println("add : "+vo);
			if(vo.getFriendList()==null){
				memberDAO.add_friend(idx, friendList+"");
			}
			else if(vo.getFriendList()!=null){
				String add = vo.getFriendList() +"/"+friendList;
				memberDAO.add_friend(idx, add);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
