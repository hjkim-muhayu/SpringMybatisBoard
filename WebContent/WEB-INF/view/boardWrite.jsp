<%@page import="com.jjambbongg.model.BoardModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
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

<form name="boardWriteForm" method="post" onSubmit="return boardWriteCheck(this);" action="./boardWrite.do">  
<input type="hidden" name="pageNum" value="<%=pageNum %>">
<input type="hidden" name="searchText" value="<%=searchText %>">

<table class="withoutBorder">
<tr>
	<th width="60" class="alignLeft"><a href="./boardList.do?pageNum=<%=pageNum%>&searchText=<%=searchText%>">List</a></th>
	<th>&nbsp;</th>
</tr>
</table> 

<table class="withBorder">
<tr>
	<td width="60" class="alignCentre">Title</td>
	<td class="alignLeft"><input name="title" type="text" maxlength="255" size="90"></td>
</tr>
<tr>
	<td colspan="2"><textarea name="contents" cols="100" rows="30"></textarea></td>
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