<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css" href="/resources/css/aside.css" />
<!-- main css -->
<link rel="stylesheet" type="text/css" href="/resources/css/basic.css" />
<!-- basic css -->

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
<!-- jquery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<%@ include file="/WEB-INF/views/include/aside.jsp"%>


	<div id="container">
	<h2>보낸 메일함</h2>
		<table class="table">
			<thead class="thead">
				<tr>
					<th class="col1" width="5%">메일번호</th>
					<th class="col2" width="10%" align="center">수신자 이메일</th>
					<th class="col3" width="55%" align="center">제목</th>
					<th class="col4" width="20%">시간</th>
					<th class="col5" width="10%">읽음 1 /안읽음 0</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${SendList }" var="email">
					<a href="/email/detail2?mailnum=${email.mailnum}">
					<tr>

						<td><c:if test="${email.readck==0 }">
								<img alt="" src="/resources/images/mail2.jpg">
							</c:if> <c:if test="${email.readck==1 }">
								<img alt="" src="/resources/images/mail3.jpg">
							</c:if></td>

						<td><c:out value="${email.receivemail }" /></td>
						<td align="center"><a
							href="/email/detail2?mailnum=${email.mailnum}"><c:out
									value="${email.title }" /></a></td>
						<td align="center"><fmt:formatDate
								value="${email.registerDate }" pattern="YYYY/MM/dd/hh:mm" /></td>
						<td><c:out value="${email.readck }" /></td>
					</tr>
					</a>
				</c:forEach>

			</tbody>
		</table>
		<div class="paging">
			<c:if test="${p.showprev }">
				<a href="/email/sendList?page=${p.beginpage-1 }&pagesize=${p.pagesize}" />&lt;</a>
			</c:if>
			<c:forEach var="i" begin="${p.beginpage }" end="${p.endpage }">
				<a href="/email/sendList?page=${i }&pagesize=${p.pagesize}&key=${p.key}&word=${p.word}">[${i }]</a>
			</c:forEach>
			<c:if test="${p.shownext }">
				<a href="/email/sendList?page=${p.endpage+1 }&pagesize=${p.pagesize}&key=${p.key}&word=${p.word}" />&gt;</a>
			</c:if>
		</div>
		</div>
</body>
</html>