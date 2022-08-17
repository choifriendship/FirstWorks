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
width: 30px;
}
  
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>

	
<div id="container">
<form action="/email/restore" method="post">
		<h2>삭제한 메일 리스트</h2>
		      <table>
		            <thead>
		                <tr>
		                    <th width="5%"><img alt="" src="/resources/images/mail2.jpg"> </th>
		                    <th width="5%">보낸사람 </th>
		         
		                    <th width="55%">제목</th>
		                    <th align="center" width="10%">시간</th>
		                    <th align="right" width="5%">&nbsp</th>
		             
		        
		                </tr>
		            </thead>
		            <tbody>
		 				
						<c:forEach items="${deleteList }" var="email">
							<tr>
							<td>&nbsp</td>
							<td><c:out value="${email.sendermail }"/></td>
				
							<td align="center"><a href="/email/detail?mailnum=${email.mailnum}">
							<c:out value="${email.title }"/></a></td>
							<td align="center"><c:out value="${email.registerDate }"/></td>
							<td><input type="hidden" value="${email.mailnum }" name='mailnum'><input type="submit" value="복구"></td>
			
							</tr>
						</c:forEach>
					 
		            </tbody>
		        </table>

     </form>
     </div>	
</body>
</html>