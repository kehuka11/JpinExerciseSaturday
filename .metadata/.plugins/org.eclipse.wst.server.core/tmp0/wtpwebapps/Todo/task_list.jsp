<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
</head>
<body>
<h1>タスク一覧</h1>
<a href="/Todo/tasksign">登録する</a>
<form action="taskchange" method="get">
<select name="list">
<option value="all">全て</option>
<option value="complete">完了</option>
<option value="incomplete">未完了</option>
</select>

<input type="submit" value="表示する">
</form>
<form action="taskcheck" method="post">
<table border="1" rules="rows">
	<tr>
		<th></th>
		<th>内容</th>
		<th>期日</th>
		<th>担当者</th>
		<th>登録者</th>
		<th>備考</th>
		<th> </th>
		<th> </th>
	</tr>
	
	<c:forEach items="${ sessionScope.map}" var="map" >
		
		
	<tr>
		<td>
			<input type="checkbox" name="check" value="${map.key }">
		</td>
		<td>
			<c:out value=" ${ map.value.contents}"></c:out>
		</td>
		<td>
			<c:out value=" ${ map.value.date}"></c:out>
		</td>
		<td>
			<c:out value=" ${ map.value.chargename}"></c:out>
		</td>
		<td>
			<c:out value=" ${ map.value.regname}"></c:out>
		</td>
		<td>
			<c:out value=" ${ map.value.bikou}"></c:out>
		</td>
		<td>
			<a href="/Todo/taskfix?id=${map.key }">修正する</a>
		</td>
		<td>
			<a href="/Todo/taskdelete?id=${map.key }">削除する</a>
		</td>
	</tr>
	
	
	</c:forEach>
</table>
<input type="submit" value="完了する">
</form>
</body>
</html>