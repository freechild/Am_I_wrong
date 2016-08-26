package All.vo;

import java.util.Date;

public class MemberVO{
	
	private int idx;
	private String Name;
	private String Pw;
	private String email;
	private Date regdate;
	private int status;
	private String hint;
	private String friends;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getFriends() {
		return friends;
	}
	public void setFriends(String friends) {
		this.friends = friends;
	}
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", Name=" + Name + ", Pw=" + Pw + ", email=" + email + ", regdate=" + regdate
				+ ", status=" + status + ", hint=" + hint + ", friends=" + friends + "]";
	}
	
	
	
}