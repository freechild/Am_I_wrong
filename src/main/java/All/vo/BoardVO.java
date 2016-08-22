package All.vo;

import java.util.Date;

/**
 * @author JJ
 *
 */
public class BoardVO {
	private int idx;
	private int mem_ref;
	private int categoryid;
	private String title;
	private String content;
	private String ip;
	private Date regdate;
	private String savefile;
	private String origfile;
	private int read;
	private int likes;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMem_ref() {
		return mem_ref;
	}
	public void setMem_ref(int mem_ref) {
		this.mem_ref = mem_ref;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
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
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", mem_ref=" + mem_ref + ", categoryid=" + categoryid + ", title=" + title
				+ ", content=" + content + ", ip=" + ip + ", regdate=" + regdate + ", savefile=" + savefile
				+ ", origfile=" + origfile + ", read=" + read + ", likes=" + likes + "]";
	}
	
	
	
	
}
