<%@page import="com.jjambbongg.model.BoardModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
BoardModel boardUpdate = new BoardModel();
if(request.getAttribute("boardUpdate")!=null) { 
	boardUpdate = (BoardModel)request.getAttribute("boardUpdate");
}

BoardModel boardModel = new BoardModel();
int pageNum = 1;
String searchText = "";
if(request.getAttribute("boardModel")!=null) {
	boardModel = (BoardModel)request.getAttribute("boardModel");
	searchText = boardModel.getSearchText();
	pageNum = Integer.parseInt(boardModel.getPageNum());
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="./resources/js/validation.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
</head>
<body>

<form name="boardWriteForm" method="post" onSubmit="return boardWriteCheck(this);" action="./boardUpdate.do">
<input type="hidden" name="pageNum" value="<%=pageNum %>">
<input type="hidden" name="searchText" value="<%=searchText %>">
<input type="hidden" name="no" value="<%=boardUpdate.getNo()%>">
<table class="withoutBorder">
<tr>
	<th width="60" class="alignLeft"><a href="./boardList.do?pageNum=<%=pageNum%>&searchText=<%=searchText%>">List</a></th>
	<th>&nbsp;</th>	
	<th width="60" class="alignRight"><a href="./boardDelete.do?no=<%=boardUpdate.getNo()%>&pageNum=<%=pageNum%>&searchText=<%=searchText%>">Delete</a></th>
</tr>
</table> 

<table class="withBorder">
<tr>
	<td width="60" class="alignCentre">Title </td>
	<td class="alignLeft"><input name="title" type="text" maxlength="255" value="<%=boardUpdate.getTitle()%>" size="90"></td>
</tr>
<tr>
	<td colspan="2"><textarea name="contents" cols="100" rows="30"><%=boardUpdate.getContents()%></textarea></td>
</tr>
<tr>
	<td colspan="2">
	<% if (boardUpdate.getModify_date()==null || boardUpdate.getCreate_date().equals(boardUpdate.getModify_date())) {%>
	<%=boardUpdate.getCreate_date()%> created
	<%} else {%>
	<%=boardUpdate.getModify_date()%> modified
	<%}%>
	</td>
</tr>
</table>

<table class="withoutBorder">
<tr>
	<td class="alignLeft"><input type="submit" value="save"></td>
</tr>
</table>

</form>

</body>
</html>