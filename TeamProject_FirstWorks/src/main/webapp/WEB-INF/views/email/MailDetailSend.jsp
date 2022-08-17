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
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	<section id="message_box">
<form action="/email/revoke" method="post">
<h2>상세페이지 (보낸 사람 )</h2>
 <div id="write_msg">
 <ul>
            <li>
                <span class="col1">보낸 사람 : </span>
                <span class="col2">${data.sendermail }</span>
            </li>
            <li>
                <span class="col1">제목 : </span>
                <span class="col2">${data.title }</span>
            </li>
          
            <li id="textarea">
                <span class="col1">내용 : </span>
                <span class="col2"><textarea rows="5" cols="80" name='content'>${data.content }</textarea></span>
            </li>  
             <li>
                <span class="col1">읽음여부: </span>
                <span class="col2">${data.registerDate }</span>
            </li>
                                       
        </ul>
        
        <input type="hidden" value="${data.mailnum }" name='mailnum'>
 
           <input type="submit" value="전송취소">


	
		   </div>	
		   </form>	
    </section>
</body>
</html>