package All.vo;

public class MessageVO {
	private int idx;
	private int sender_idx;
	private int recipient_idx;
	private String message;
	private int add_status;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAdd_status() {
		return add_status;
	}
	public void setAdd_status(int add_status) {
		this.add_status = add_status;
	}
	@Override
	public String toString() {
		return "MessageVO [idx=" + idx + ", sender_idx=" + sender_idx + ", recipient_idx=" + recipient_idx
				+ ", message=" + message + ", add_status=" + add_status + "]";
	}
	
	
	
	
	
	
}
