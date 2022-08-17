<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/mailform.css" /><!-- basic css -->


</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	<section id="message_box">
	<h2>상세페이지(받은 메일 )</h2>
	  <div id="write_msg">
	<ul>
            <li>
                <span class="col1">보낸 사람 : </span>
                <span class="col2">${data.sendermail }</span>
            </li>
            <li>
                <span class="col1">시간: </span>
                <span class="col2">${data.registerDate }</span>
            </li>
            <li>
                <span class="col1">제목 : </span>
                <span class="col2">${data.title }</span>
            </li>
            <li id="textarea">
                <span class="col1">내용 : </span>
                <span class="col2"><textarea rows="5" cols="80" name='content'>${data.content }</textarea></span>
            </li>                                
        </ul>
     
			<c:if test="${data.delck==0 }">
			  
				 <a class="mailbtn" href="/email/reply?receivemail=${data.sendermail}">답장하기</a>
			</c:if>
		
           </div>
	 </section>
</body>
</html>