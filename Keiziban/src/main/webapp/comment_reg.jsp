<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reply" method="get">
名前 <input type="text" name="repname">
<input type="hidden" name="id" value="3">
追加コメント<input type="text" name="addcomment"><br>
<input type="button" onclick="location.href='http://localhost:8080/Keiziban/keiziban.jsp'" 
value="戻る" />
<input type="submit" value="追加する">

</form>
</body>
</html>