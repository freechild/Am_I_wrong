package All.vo;

import java.util.Date;

public class TotalVO {
	private String name;
	private int idx;
	private int mem_ref;
	private String categoryid;
	private String title;
	private String content;
	private String ip;
	private Date regdate;
	private int likes;
	private int read;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public int getMem_ref() {
		return mem_ref;
	}
	public void setMem_ref(int mem_ref) {
		this.mem_ref = mem_ref;
	}
	@Override
	public String toString() {
		return "TotalVO [name=" + name + ", idx=" + idx + ", mem_ref=" + mem_ref + ", categoryid=" + categoryid
				+ ", title=" + title + ", content=" + content + ", ip=" + ip + ", regdate=" + regdate + ", likes="
				+ likes + ", read=" + read + "]";
	}
	
	
	
	
}
