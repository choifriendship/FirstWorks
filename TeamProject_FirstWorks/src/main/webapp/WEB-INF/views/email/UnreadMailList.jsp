<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->

<style>
#container{

width:1200px; height: 500px;

position: absolute;
left: 22.5%; top: 20%;
}


  table {
	width:100%;
   
    border-collapse: collapse;
    display: block;
    position: relative;
 
  }
  thead tr {
  
 	height: 40px;
    background: #B2B2B2;

}
td{

    height: 40px;

    border-bottom:1px solid black;

}
img{
 width: 20px;
}
  
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	<div id="container">

          
    <h2>읽지 않은 메일함 </h2>
    <p>	 안읽은 메일 수 :${Unreadcount} </p>
        <table>
            <thead>
                <tr>
                    <th width="5%"><img alt="" src="/resources/images/mail2.jpg"></th>
                    <th width="5%">보낸 사람</th>
                    <th width="5%">보낸 사람 이메일</th>
                    <th width="55%"  align="center">제목</th>
                    <th width="5%">시간</th>
                    <th width="5%">읽음 1 /안읽음 0</th>
        
                </tr>
            </thead>
            <tbody>
 				
				<c:forEach items="${Unreadlist }" var="email">
					<tr>
					<td><a href="/email/detail?mailnum=${email.mailnum}"><img alt="" src="/resources/images/mail2.jpg"></a></td>
					<td><c:out value="${email.memnum }"/></td>
					<td><c:out value="${email.sendermail }"/></td>
					<td><c:out value="${email.registerDate }"/></td>
					<td><a href="/email/detail?mailnum=${email.mailnum}"><c:out value="${email.title }"/></a></td>
					<td><c:out value="${email.readck }"/></td>
					</tr>
				</c:forEach>
            </tbody>
        </table>
	</div>  

</body>
</html>