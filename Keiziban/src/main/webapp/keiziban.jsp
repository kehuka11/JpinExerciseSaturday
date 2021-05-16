<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
<link rel="stylesheet" type="text/css" href="css/keiziban.css" />
</head>
<body>
	
<h1>掲示板</h1>
<a href="http://localhost:8080/Keiziban/topic_reg.jsp">投稿する</a>

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
	
		<td>
			<c:out value=" ${ topic.dai}"></c:out>
		</td>
		<td>
			<c:out value=" ${ topic.name}"></c:out>
		</td>
		<td>
			<fmt:formatDate value="${topic.date }" pattern="YYYY-MM-dd-HH-mm"/>
		</td>
		<td>
			<c:out value=" ${ topic.comment}"></c:out>
		</td>
		<td>
			<a href="http://localhost:8080/Keiziban/comment.jsp?id=${topic.id }">[参照/返信]</a>
		</td>

	</tr>
	</c:forEach>
	
</table>

	
</body>
</html>