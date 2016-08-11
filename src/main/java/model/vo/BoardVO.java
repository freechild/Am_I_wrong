package model.vo;

import java.util.Date;

public class BoardVO {
	private int idx;
	private int categoryid;
	private String name;
	private String pw;
	private String title;
	private String content;
	private String ip;
	private int hit;
	private Date regdate;
	private String email;
	private String savefile;
	private String origfile;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSavefile() {
		return savefile;
	}
	public void setSavefile(String savefile) {
		this.savefile = savefile;
	}
	public String getOrigfile() {
		return origfile;
	}
	public void setOrigfile(String origfile) {
		this.origfile = origfile;
	}
	
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", categoryid=" + categoryid + ", name=" + name + ", pw=" + pw + ", title="
				+ title + ", content=" + content + ", ip=" + ip + ", hit=" + hit + ", regdate=" + regdate + ", email="
				+ email + ", savefile=" + savefile + ", origfile=" + origfile + "]";
	}
	
	
	
}
