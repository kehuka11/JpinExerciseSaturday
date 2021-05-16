<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>完了したタスク一覧</h1>
<table border="1" rules="rows">
	<tr>
		
		<th>内容</th>
		<th>期日</th>
		<th>担当者</th>
		<th>登録者</th>
		<th>備考</th>
		
	</tr>
	
	<c:forEach items="${ sessionScope.compmap}" var="compmap" >
		
		
	<tr>
		
		<td>
			<c:out value=" ${ compmap.value.contents}"></c:out>
		</td>
		<td>
			<c:out value=" ${ compmap.value.date}"></c:out>
		</td>
		<td>
			<c:out value=" ${ compmap.value.chargename}"></c:out>
		</td>
		<td>
			<c:out value=" ${ compmap.value.regname}"></c:out>
		</td>
		<td>
			<c:out value=" ${ compmap.value.bikou}"></c:out>
		</td>
		
	</tr>
	
	
	</c:forEach>
</table>
</body>
</html>