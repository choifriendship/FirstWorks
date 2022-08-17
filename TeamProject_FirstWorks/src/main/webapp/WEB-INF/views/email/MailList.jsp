<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/header.css" /><!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/aside.css" /><!-- main css -->
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<%@ include file="/WEB-INF/views/include/aside.jsp" %>
    <section>
    <h2>전체 메일함 && 메일 클릭시 메인 화면 입니다</h2>
    <p>안녕하세요  ${member.mem_nm}  님</p>
        <table border="1">
            <thead>
                <tr>
                	<th>&nbsp</th>
                    <th>발신인 </th>
                    <th>발신자 이메일</th>
                    <th>수신자 이메일</th>
                    <th>제목</th>
        
                </tr>
            </thead>
            <tbody>
 				
				<c:forEach items="${MailList }" var="email">
					<tr>
					<td><c:out value="${email.sendermail }"/></td>
					<td><c:out value="${email.receivemail }"/></td>
					<td><c:out value="${email.title }"/></td>
					</tr>
				</c:forEach>
			 
            </tbody>
        </table>
    </section>
</div>
</body>
</html>

