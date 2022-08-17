<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<!-- 이모티콘 -->
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<!-- css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/aside.css" /><!-- main css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/basic.css" /><!-- basic css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css" /><!-- main css -->

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
	<section>
        <article id="a1">
            <h1 class="mainTitle">전자결재</h1>
            <h1 class="mainTitle">일정 달력 ?</h1>
            <h1 class="mainTitle">공지사항</h1>

      
            <div id="todayWork">
                <!--여기 작성 3-->
               
            </div>
            
            <div id="myInfo">
             
               
            </div>
            <div id="myInfo">
            
            </div>
            
          
        </article>
        <article id="a2">
            <h1 class="mainTitle">전자결재</h1>
            <h1 class="mainTitle">일정 달력 ?</h1>
            <h1 class="mainTitle">공지사항</h1>

      
            <div id="todayWork">
                <!--여기 작성 3-->
               
            </div>
            
            <div id="myInfo">
             
               
            </div>
             <div id="myInfo">
             
               
            </div>
            
          
        </article>

			
    </section>

</body>
</html>