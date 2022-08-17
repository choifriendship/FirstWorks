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

  .table {
	width:100%;
   
    border-collapse: collapse;
    display: block;
    position: relative;
 
  }
  .thead tr {
  
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
 .unread img{
 width: 50px; height: 30px;

 }
 .paging{
 width:100%; height:30%;
  position: relative; top:30px;
 margin: 0 auto;
 }
</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	<div id="container">
	<h2>받은 메일함</h2>
	<a class="unread" href="/email/unreadList"><img src="/resources/images/unreadmail.jpg"></a>
	<form action="/email/delupdate" method="post">
	
    <table class="table table-hover">
    	   <thead class="thead">
                <tr>
                	<th width="5%">&nbsp</th>
                    <th width="5%">보낸 사람 번호</th>
                    <th width="5%">보낸 사람 이메일</th>
                    <th width="55%" align="center">제목</th>
                    <th width="5%">시간</th>
                    <th width="5%">읽음 1 /안읽음 0</th>
                    <th width="5%">삭제</th>
                </tr>
            </thead>
            <tbody>
 				
				<c:forEach items="${ReceiveList }" var="email">
				
					<tr>
					<!-- 메일 읽었으면 사진 변경  -->
					<td>
					<a href="/email/detail?mailnum=${email.mailnum}">
					<c:if test="${email.readck==0 }">
						<img alt="" src="/resources/images/mail2.jpg">
					</c:if>
					<c:if test="${email.readck==1 }">
						<img alt="" src="/resources/images/mail3.jpg">
					</c:if>
					
		
					</a></td>
					
					<td><c:out value="${email.memnum }"/></td>
					<td><c:out value="${email.sendermail }"/></td>
					<td align="center"><a href="/email/detail?mailnum=${email.mailnum}"><c:out value="${email.title }"/></a></td>
					<td><fmt:formatDate value="${email.registerDate }" pattern="yyyy/MM/dd/hh:mm:ss"/></td>
					
					<td align="right"><c:out value="${email.readck }"/></td>
					<td align="right"><input type="hidden" value="${email.mailnum }" name='mailnum'>
					<input type="submit" value="삭제"></td>					
					</tr>
					
				</c:forEach>
			 
            </tbody>
   		 </table>
        </form>	
        <div class="paging">
	        <c:if test="${p.showprev }">
				<a href="/email/receiveList?page=${p.beginpage-1 }&pagesize=${p.pagesize}"/>&lt;</a>
			</c:if>						
			<c:forEach  var="i"  begin="${p.beginpage }" end="${p.endpage }"  >
				<a href="/email/receiveList?page=${p.beginpage-1 }&pagesize=${p.pagesize}">[ ${i } ]</a>
			</c:forEach>						
			<c:if test="${p.shownext }">
				<a href="/email/receiveList?page=${p.beginpage-1 }&pagesize=${p.pagesize}"/>&gt;</a>
			</c:if>
		</div>
 
	</div>  
</body>
</html>