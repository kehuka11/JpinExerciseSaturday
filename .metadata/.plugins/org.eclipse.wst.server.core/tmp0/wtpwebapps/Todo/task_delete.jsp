<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除</title>
</head>
<body>

<h1>タスクを削除する</h1>

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
			<c:out value=" ${ idd}"></c:out>
		</td>
		<td>
			<c:out value=" ${ del.contents}"></c:out>
		</td>
		<td>
			<c:out value=" ${ del.date}"></c:out>
		</td>
		<td>
			<c:out value=" ${ del.chargename}"></c:out>
		</td>
		<td>
			<c:out value=" ${ del.regname}"></c:out>
		</td>
		<td>
			<c:out value=" ${ del.bikou}"></c:out>
		</td>
	</tr>
	
</table>

<form action="taskdelete" method="post">
<input type="button" onclick="location.href='http://localhost:8080/Todo/task_list.jsp'" 
value="戻る" />
<input type="hidden" value="${idd }" name="id">
<input type="submit" value="削除">
</form>
</body>
</html>