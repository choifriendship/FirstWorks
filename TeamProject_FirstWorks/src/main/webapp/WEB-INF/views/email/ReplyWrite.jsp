<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="/resources/css/aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="/resources/css/mailform.css" /><!-- basic css -->
<%
String receiveMail =(String)session.getAttribute("receiveMail");

%>
</head>
<body>


	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
<section id="message_box">
<h2>답장</h2>
<form method="post" action="/email/replypro"> 
<!-- post방식으로 자료를 컨트롤러로 보냄 -->
 <div id="write_msg">
	<input type="hidden" value="${mem_no}" name='memnum'><br>
	 <br>
        <ul>
            <li>
                <span class="col1">받는 사람 : </span>
                <span class="col2"><%=receiveMail %> <input type="hidden" value="<%= receiveMail %>" name='receivemail'></span>
            </li>
            <li>
                <span class="col1">수신 이메일: </span>
                <span class="col2">${mem_eml}<input type="hidden" value="${mem_eml}" name='sendermail'></span>
            </li>
            <li>
                <span class="col1">제목 : </span>
                <span class="col2"><input name='title'></span>
            </li>
            <li id="textarea">
                <span class="col1">내용 : </span>
                <span class="col2"><textarea rows="5" cols="80" name='content'></textarea></span>
            </li>                                
        </ul>
        <!-- 서밋버튼 -->
        <input type="submit" value="보내기">
    </div>
	</form>
		
   </section>
</body>
</html>