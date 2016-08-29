package member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import All.vo.MessageVO;
import All.vo.TotalVO;
import member.dao.MemberDAO;
import member.dao.MessageDAO;

@Service
public class MessageService {
	
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private MemberDAO memberDAO;
	
	
	public void insert(MessageVO vo){	
		try {			
			TotalVO Tvo1 = 
			memberDAO.selectByIdx(vo.getRecipient_idx());
			TotalVO Tvo2 = 
					memberDAO.selectByIdx(vo.getSender_idx());
			vo.setMessage(Tvo2.getName() + "님이 " +Tvo1.getName() +"님에게 친구신청을 합니다.");
			vo.setAdd_status(1);
			System.out.println(vo);
			messageDAO.insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public List<TotalVO> selectList(int both_idx){
		List<TotalVO> list=null;
		try {
			list = messageDAO.selectList(both_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public int getCount(int both_idx){
		int result = 0;
		try {
			result = messageDAO.getCount(both_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public TotalVO selectByIdx(int idx){
		TotalVO vo =null;
		try {
			vo = messageDAO.selectByIdx(idx);
			TotalVO Tvo1 = 
					memberDAO.selectByIdx(vo.getRecipient_idx());
			TotalVO Tvo2 = 
					memberDAO.selectByIdx(vo.getSender_idx());
			vo.setRecipient(Tvo1.getName());
			vo.setSender(Tvo2.getName());
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return vo;
	}
	public void delete(int idx){
		try {
			messageDAO.delete(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
