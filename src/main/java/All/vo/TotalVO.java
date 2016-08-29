package All.vo;

import java.util.Date;

public class TotalVO {
	//member
	private String name;
	
	//board && all
	private int idx;
	private int mem_ref;
	private String categoryid;
	private String title;
	private String content;
	private String ip;
	private Date regdate;
	private int likes;
	private int read;
	private String friendList;
	
	//message
	
	private String sender;
	private String recipient;
	private int sender_idx;
	private int recipient_idx;
	private int add_status;
	private String message;
	
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
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
	
	public String getFriendList() {
		return friendList;
	}
	public void setFriendList(String friendList) {
		this.friendList = friendList;
	}
	public int getAdd_status() {
		return add_status;
	}
	public void setAdd_status(int add_status) {
		this.add_status = add_status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getSender_idx() {
		return sender_idx;
	}
	public void setSender_idx(int sender_idx) {
		this.sender_idx = sender_idx;
	}
	public int getRecipient_idx() {
		return recipient_idx;
	}
	public void setRecipient_idx(int recipient_idx) {
		this.recipient_idx = recipient_idx;
	}
	@Override
	public String toString() {
		return "TotalVO [name=" + name + ", idx=" + idx + ", mem_ref=" + mem_ref + ", categoryid=" + categoryid
				+ ", title=" + title + ", content=" + content + ", ip=" + ip + ", regdate=" + regdate + ", likes="
				+ likes + ", read=" + read + ", friendList=" + friendList + ", sender=" + sender + ", recipient="
				+ recipient + ", sender_idx=" + sender_idx + ", recipient_idx=" + recipient_idx + ", add_status="
				+ add_status + ", message=" + message + "]";
	}

	
	

	
	
	
	
}
