<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	글번호 : ${dto.mnum }<br><br>
	글쓴이 : ${dto.mwriter }<br><br>
	글내용 : ${dto.mcontent }<br><br>
	<hr>
	<a href="list">글목록보기</a>
</body>
</html>