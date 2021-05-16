<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.Optional" %>
<%
int id = Integer.parseInt( request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="http://localhost:8080/Keiziban/keiziban.jsp">掲示板に戻る</a>
<table border="1" class="table">
	<tr>
		<th>topic</th>
		<th>名前</th>
		<th>日時</th>
		<th>コメント</th>
		<th>返信</th>
		
	</tr>
	
	<c:forEach items="${ sessionScope.list}" var="topic" varStatus="status">
	<tr>
		<td<c:if test="${topic.id == id}"></c:if>>
			
			<c:out value=" ${ topic.dai}"></c:out>
			
		</td>
		<td<c:if test="${topic.id == id}"></c:if>>
			<c:out value=" ${ topic.name}"></c:out>
		</td>
		<td<c:if test="${topic.id == id}"></c:if>>
			<fmt:formatDate value="${topic.date }" pattern="YYYY-MM-dd-HH-mm"/>
		</td>
		<td<c:if test="${topic.id == id}"></c:if>>
			<c:out value=" ${ topic.comment}"></c:out>
		</td>
		<td<c:if test="${topic.id == id}"></c:if>>
			<c:out value=" ${ topic.addcomment}"></c:out>
		</td>
	
	

	</tr>
	</c:forEach>
	
</table>

<form action="reply" method="get">
名前 <input type="text" name="repname">
<input type="hidden" name="id" value=<%= id%>>
追加コメント<input type="text" name="addcomment"><br>
<input type="button" onclick="location.href='http://localhost:8080/Keiziban/keiziban.jsp'" 
value="戻る" />
<input type="submit" value="返信する">

</form>


</body>
</html>