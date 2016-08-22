package All.vo;

import java.util.Date;

public class CommentVO {
	private int idx;
	private int mem_ref;
	private int b_ref;
	private String content;
	private Date regdate;
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
	public int getB_ref() {
		return b_ref;
	}
	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
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
		return "CommentVO [idx=" + idx + ", mem_ref=" + mem_ref + ", b_ref=" + b_ref + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	
	
}
