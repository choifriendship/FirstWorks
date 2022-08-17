<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.main_nav{
      
      width: 280px; height:800px;
      border: 1px solid;
      position: absolute;
    }
                #profile{
                  width: 100%; height: 35%;
                  position: relative;
                }
                #profile #profile_image{
                  width: 150px; height: 150px;
                  position: relative;
                  left: 25%; top: 5%;
                  border: 1px solid;
                }
                #profile p{
                width: 280px; height: 30px;
                }
                
                #profile #logout{
                  text-align: center;
                  width: 280px; height: 30px;
                  background-color: rgba(97, 255, 208, 0.877);
                }
                #mail_section1{
      
                  width: 100%; height: 15%;
                  line-height: 1.5;
                  border-bottom: 1px solid;
                }
                #mail_section1 .sec{
                  width: 90px;height: 100px;
                  float: left;
                  margin:1px;

                }
           
                #mail_section1 ul li{
              
                  margin: 5px;
                  background-color: antiquewhite;
                }
                #mail_section2{
              width: 100%; height: 70%;
              text-align: center;

                }
                #mail_section2 ul {
                  text-align: left;
           

                }
                #mail_section2 ul li{
                
                  list-style: none;     
                    line-height:2.0;
                  font-weight: 600;
                  border-bottom: 1px solid black;

                }
                #mail_section2 ul li a{
                  text-decoration: none;
                }
                #a{
                	color: red;
                	border: 1px solid black;
                	background-color: black;
                	border-radius: 100px;
                }
</style>
</head>
<body>
  <div class="main_nav">

    <div id="profile">
      <div id="profile_image"><img src="" alt="프로필 사진"></div>
	<br>
      <p>이름${mem_nm} </p>
      <p>부서</p>
      <p id="logout"><a href="@" >logout</a></p>
     </div>

     <div id="mail_section1">
<div id="sec1" class="sec"><a href="write">메일쓰기</a></div>
<div id="sec2" class="sec"> <a href="unreadList">안읽음</a>
		<c:if test="${Unreadcount!=null}"><span id="a">${Unreadcount}</span></c:if>
		
		 </div>
<div id="sec3" class="sec"> <a href="@">주소록</a></div>


   
     </div>
     
     <div id="mail_section2">
       <ul>
        <li><a href="MailList">전체 메일</a></li>
        <li><a href="receiveList">받은 메일</a></li>
        <li><a href="sendList">보낸메일</a></li>
        <li><a href="deleteList">삭제한 메일함</a></li>
       </ul>
     </div>
  <div>
</div>
</div>


</body>
</html>