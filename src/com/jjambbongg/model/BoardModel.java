package com.jjambbongg.model;

import java.io.Serializable;

public class BoardModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private int no;
	private String title;
	private String contents;
	private String modify_date;
	
	/** paging **/
	private String pageNum = "1";		// current page number
	private int listCount = 20;			// row count in one page
	private int pagePerBlock = 20;
	private int startIndex = 0;
	private String searchText = "";
	
	public BoardModel() {
		super();
	}
	
	public BoardModel(int no, String title, String contents, String modify_date, String pageNum, int listCount, int pagePerBlock, int startIndex, String searchText) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.modify_date = modify_date;
		this.pageNum = pageNum;
		this.listCount = listCount;
		this.pagePerBlock = pagePerBlock;
		this.startIndex = startIndex;
		this.searchText = searchText;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	
	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
	@Override
	public String toString() {
		return "BoardModel [no=" + no + ", title=" + title + ", contents=" + contents + ", modify_date=" + modify_date + ", pageNum=" + pageNum + ", listCount=" + listCount
				+ ", pagePerBlock=" + pagePerBlock + ", startIndex=" + startIndex + ", searchText=" + searchText + "]";
	}
	
	
}
