package model.vo;

import java.util.Date;

public class MemberVO {
	
	private int idx;
	private String name;
	private String email;
	private String hint;
	private String pw;
	private int status;
	private Date regdate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", email=" + email + ", pw=" + pw + ", status=" + status + ", regdate="
				+ regdate + "]";
	}
	
	
	
}
