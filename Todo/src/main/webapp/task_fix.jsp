<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク修正</title>
</head>
<body>
<h1>タスクを修正する</h1>

<table border="1" rules="rows">
	<tr>
	<th>id</th>
		<th>内容</th>
		<th>期日</th>
		<th>担当者</th>
		<th>登録者</th>
		<th>備考</th>
	</tr>

	
	<tr>
		<td>
			<c:out value=" ${ idf}"></c:out>
		</td>
		<td>
			<c:out value=" ${ todo.contents}"></c:out>
		</td>
		<td>
			<c:out value=" ${ todo.date}"></c:out>
		</td>
		<td>
			<c:out value=" ${ todo.chargename}"></c:out>
		</td>
		<td>
			<c:out value=" ${ todo.regname}"></c:out>
		</td>
		<td>
			<c:out value=" ${ todo.bikou}"></c:out>
		</td>
	</tr>
	
</table>
<form action="taskfix" method="post">
登録者<input type="text" value="${ todo.regname}" name="regname"><br>
内容<input type="text" value="${ todo.contents}" name="contents"><br>
期日<input type="date" min="2021-04-01" max="2030-04-01" value="${ todo.date}" name="date"><br>
担当者<input type="text" value="${ todo.chargename}" name="chargename"><br>
備考<input type="text" value="${ todo.bikou}" name="bikou"><br>
<input type="hidden" value="${idf }" name=id>
<input type="button" onclick="location.href='http://localhost:8080/Todo/task_list.jsp'" 
value="戻る" />
<input type="submit" value="修正">
</form>
</body>
</html>