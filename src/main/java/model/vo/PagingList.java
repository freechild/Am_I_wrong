package model.vo;

import java.util.List;

public class PagingList<T> {
	private List<T> list;
	
	private int totalCount;
	private int	currentPage;
	private int	pageSize;
	private int	blockSize;
	
	private int totalPage;
	private int startNo;
	private int	startPage;
	private int endNo;
	private int endPage;
	
	public PagingList(int totalCount, int currentPage, int pageSize, int blockSize) {
		super();
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		calc();
	}
	
	private void calc(){
		if(totalCount>0){
			if(pageSize<5) pageSize=10;
			if(blockSize<5)blockSize=10;
			totalPage = (totalCount-1) / pageSize +1;
			if(currentPage<1 || currentPage>totalPage) currentPage=1;
			startNo = (currentPage-1) * pageSize +1;
			endNo = startNo + pageSize -1;
			if(endNo > totalCount) endNo = totalCount;
			startPage = (currentPage-1) / blockSize * blockSize +1;
			endPage = startPage + blockSize -1;
			if(endPage> totalPage) endPage = totalPage;
		}else{
			totalCount=currentPage=0;
			pageSize=blockSize=10;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndNo() {
		return endNo;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
}
