<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>휴가결재서</h1>
	<h4>사원</h4>
	<p></p>
	<h4>중간관리자</h4>
	<p></p>
	<h4>최종관리자</h4>
	<p></p>
	<h1>결재내용</h1>
	<form action="/vcpro" method="post">
		<textarea rows="40" cols="40" name="text"></textarea>
		<input type="submit" value="완료">		
	</form>
</body>
</html>