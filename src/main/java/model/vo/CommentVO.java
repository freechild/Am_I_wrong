package model.vo;

import java.util.Date;

public class CommentVO {
	private int idx;
	private int ref;
	private String name;
	private String pw;
	private String content;
	private Date regdate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "CommentVO [idx=" + idx + ", ref=" + ref + ", name=" + name + ", pw=" + pw + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	
}
