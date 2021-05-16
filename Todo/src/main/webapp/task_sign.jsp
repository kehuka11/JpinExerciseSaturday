<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録</title>
</head>
<body>
<h1>タスクを登録する</h1>
<form action="tasksign" method="post">
登録者<input type="text" name="regname"><br>
内容<input type="text" name="contents"><br>
期日<input type="date" min="2021-04-01" max="2030-04-01" name="date"><br>
担当者<input type="text" name="chargename"><br>
備考<input type="text" name="bikou"><br>
<input type="button" onclick="location.href='http://localhost:8080/Todo/task_list.jsp'" 
value="戻る" />
<input type="submit" value="登録">
</form>
</body>
</html>