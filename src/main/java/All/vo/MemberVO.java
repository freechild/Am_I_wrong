package All.vo;

import java.util.Date;

public class MemberVO {
	
	private int idx;
	private String userId;
	private String userName;
	private String userPw;
	private String email;
	private String zipcode;
	private String address1;
	private String address2;
	private Date regdate;
	private int status;
	private String hint;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", userId=" + userId + ", userName=" + userName + ", userPw=" + userPw
				+ ", email=" + email + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2
				+ ", regdate=" + regdate + ", status=" + status + ", hint=" + hint + "]";
	}
	
	
}
