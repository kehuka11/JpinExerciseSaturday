<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トピックの投稿</title>
</head>
<body>
<form action="topic" method="post">
題目 <input type="text" name="dai"><br>
名前 <input type="text" name="name" /><br>
コメント <input type="text" name="comment"><br>
<input type="button" onclick="location.href='http://localhost:8080/Keiziban/keiziban.jsp'" 
value="戻る" />
<input type="submit" value="投稿" />
</form>

</body>
</html>