package com.jjambbongg.util;

public class PageNavigator {

	/*
	 * totalCount : total count of list
	 * listCount : page count of one page
	 * pagePerBlock : showing block
	 * pageNum : current page number
	 * searchText : search text
	 */
	
	public String getPageNavigator(int totalCount, int listCount, int pagePerBlock, int pageNum, String searchText) {
		
		StringBuffer sb = new StringBuffer();
		if(totalCount > 0) {
			int pageTemp = (totalCount % listCount);
			int totalNumOfPage = 0;
			if(pageTemp==0) {
				totalNumOfPage = (totalCount / listCount );
			} else {
				totalNumOfPage = (totalCount / listCount ) + 1;
			}
			int totalNumOfBlock = (totalNumOfPage / pagePerBlock) + 1;
			int currentBlock = ((pageNum-1) / pagePerBlock) + 1;
		
			int startPage = (currentBlock - 1) * pagePerBlock + 1;
			int endPage = startPage + pagePerBlock - 1;
			
			if(endPage > totalNumOfPage) {
				endPage = totalNumOfPage;
			}
			boolean hasNext = false;
			boolean hasPrev = false;
			
			if(currentBlock < totalNumOfBlock) {
				hasNext = true;
			}
			if(currentBlock > 1) {
				hasPrev = true;
			}
			if(totalNumOfBlock == 1) {
				hasNext = false;
				hasPrev = false;
			}
			
			if(pageNum > 1) {
				sb.append("<a href=\"").append("boardList.do?pageNum=1&amp;searchText="+searchText);
				sb.append("\" title=\"<<\"><<</a>&nbsp;");
			}
			
			if (hasPrev) {
				int goPrevPage = startPage - pagePerBlock;			
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList.do?pageNum="+goPrevPage+"&amp;searchText="+searchText);
				sb.append("\" title=\"<\"><</a>");
			} else {
				
			}
			
			for (int i = startPage; i <= endPage; i++) {
				if (i == pageNum) {
					sb.append("<a href=\"#\"><strong>").append(i).append("</strong></a>&nbsp;&nbsp;");
				} else {
					sb.append("<a href=\"").append("boardList.do?pageNum="+i+"&amp;searchText="+searchText);
					sb.append("\" title=\""+i+"\">").append(i).append("</a>&nbsp;&nbsp;");
				}
			}
			if (hasNext) {
				int goNextPage = startPage + pagePerBlock;
	
				sb.append("<a href=\"").append("boardList.do?pageNum="+goNextPage+"&amp;searchText="+searchText);
				sb.append("\" title=\">\">></a>");
			} else {
				
			}
			if(totalNumOfPage > pageNum){
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList.do?pageNum="+totalNumOfPage+"&amp;searchText="+searchText);
				sb.append("\" title=\">>\">>></a>");
			}
		}
		return sb.toString();
	}
}
