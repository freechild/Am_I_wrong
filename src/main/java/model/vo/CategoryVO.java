package model.vo;

public class CategoryVO {
	private int idx;
	private String item;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "CategoryVO [idx=" + idx + ", item=" + item + "]";
	}
}
