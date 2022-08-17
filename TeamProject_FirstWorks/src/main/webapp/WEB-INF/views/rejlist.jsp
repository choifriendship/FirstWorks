<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
  	<title>반려리스트</title>
  	<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css" /><!-- main css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="/resources/css/style.css">

	</head>
	<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">반려리스트</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<form action="/rejlist">
						<select name="key">
							<option value="t" ${(p.key=="t")?"selected" : "" }>제목</option>
							<option value="c" ${(p.key=="c")?"selected" : "" }>내용</option>
							<option value="tc" ${(p.key=="tc")?"selected" : "" }>제목+내용</option>
						</select>
						<input type="text" name="word" value="${p.word }">
						<input type="submit" value="검색">
					</form>
					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-primary">						 
						    <tr>
						      <th>문서번호</th>
						      <th>기안자</th>
						      <th>제목</th>
						      <th>종류</th>
						    </tr>
						  </thead>
						  <tbody>
						 <c:forEach items="${list}" var="l">						
								<tr>			
									<td scope="row">${l.apv_no }</td>
									<td>${l.mem_nm }</td>
									<td><a href="/rejdetail?apv_no=${l.apv_no }"><span>${l.apv_vc_tit }</span></a></td>
									<td>휴가</td>
								</tr>													
						</c:forEach>						    	    
						  </tbody>
						</table>
					</div>					
				</div>			
			</div>		
				<div>
						<c:if test="${p.showprev }">
							<a href="rejlistpage=${p.beginpage-1 }&pagesize=${p.pagesize}&key=${p.key}&word=${p.word}"/>&lt;</a>
						</c:if>
						<%-- <c:if test="${p.totalcnt>10 }"> --%>
						<c:forEach  var="i"  begin="${p.beginpage }" end="${p.endpage }"  >
							<a href="rejlist?page=${i }&pagesize=${p.pagesize}&key=${p.key}&word=${p.word}">${i }</a>
						</c:forEach>
						<%-- </c:if> --%>
						<c:if test="${p.shownext }">
							<a href="rejlist?page=${p.endpage+1 }&pagesize=${p.pagesize}&key=${p.key}&word=${p.word}"/>&gt;</a>
						</c:if>
					</div>					
			<a href="/main">메인으로</a>
		</div>
			
			
			
	</section>

	<script src="/resources/js/jquery.min.js"></script>
  <script src="/resources/js/popper.js"></script>
  <script src="/resources/js/bootstrap.min.js"></script>
  <script src="/resources/js/main.js"></script>

	</body>
</html>

