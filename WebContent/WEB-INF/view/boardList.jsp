<%@page import="com.jjambbongg.util.PageNavigator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jjambbongg.model.BoardModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<% 
int totalCount = 0;
if(request.getAttribute("totalCount")!=null) { 
	totalCount = (int) request.getAttribute("totalCount");
}

List<BoardModel> boardList = new ArrayList();
if(request.getAttribute("boardList")!=null) {
	boardList = (List<BoardModel>)request.getAttribute("boardList");
}

BoardModel boardModel = new BoardModel();
int pageNum = 1;
int listCount = 0;
int pagePerBlock = 0;
String searchText = "";
if(request.getAttribute("boardModel")!=null) {
	boardModel = (BoardModel)request.getAttribute("boardModel");
	searchText = boardModel.getSearchText();
	pageNum = Integer.parseInt(boardModel.getPageNum());
	listCount = boardModel.getListCount();
	pagePerBlock = boardModel.getPagePerBlock();	
}

String pageStr = "";
if(request.getAttribute("PageNavigator")!=null) {
	pageStr = (String) request.getAttribute("PageNavigator");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
</head>
<body>

<table class="withoutBorder">
<tr>
	<th width="60" class="alignLeft"><a href="./index.do">index</a></th>
	<th>&nbsp;</th>
	<th width="60" class="alignRight">
		<a href="./boardWrite.do?pageNum=<%=pageNum%>&searchText=<%=searchText%>">Write</a>
	</th>
		
</tr>
</table> 

<table class="withoutBorder">
<tr>
	<td class="alignRight">Total:<%=totalCount %></td>
</tr>
</table>

<table class="withBorder">
<tr>
	<th width="60" class="alignCentre">No</th>
	<th width="250">Title</th>
	<th>Contents</th>
	<th width="130" class="alignCentre">Create Date</th>
</tr>

<% for (int i=0; i<boardList.size(); i++) { 
	BoardModel board = boardList.get(i);
	String contentStr = board.getContents();
	String titleStr = board.getTitle();
	int maxConIdx = 100;
	int maxTitIdx = 40;
	if(contentStr.length() <= maxConIdx) {
		maxConIdx = contentStr.length();
	} 
	contentStr = contentStr.substring(0, maxConIdx);
	
	if(titleStr.length() <= maxTitIdx) {
		maxTitIdx = titleStr.length();
	} 
	titleStr = titleStr.substring(0, maxTitIdx);
		
%>
<tr>
	<td class="alignCentre"><a href="./boardUpdate.do?no=<%=board.getNo()%>&pageNum=<%=pageNum%>&searchText=<%=searchText%>"><%=((pageNum-1) * listCount) + (i + 1)%></a></td>
	<td><a href="./boardUpdate.do?no=<%=board.getNo()%>&pageNum=<%=pageNum%>&searchText=<%=searchText%>"><%=titleStr%></a></td>
	<td><a href="./boardUpdate.do?no=<%=board.getNo()%>&pageNum=<%=pageNum%>&searchText=<%=searchText%>"><%=contentStr%></a></td>
	<td class="alignCentre"><a href="./boardUpdate.do?no=<%=board.getNo()%>&pageNum=<%=pageNum%>&searchText=<%=searchText%>"><%=board.getCreate_date()%></a></td>
</tr>
<% } %>
</table>

<table class="withoutBorder">
<tr>
	<td class="alignCentre"><%=pageStr%></td>
</tr>
</table>

</body>
</html>