<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="right-aside">
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<!--여기 작성 2-->
	<button class="aside-accordion" onclick="location.href='/mydetail'"><i class="far fa-calendar-alt"></i><p class="mobile-hidden">&nbsp&nbsp 내정보</p></button>
          <div class="panel">
              <a href="#"></a>
          </div>
  
          <button class="aside-accordion"><p class="float-L"><i class="far fa-file-alt"></i><p class="mobile-hidden">&nbsp&nbsp 전자결재</p><i class="fas fa-angle-down float-R"></i></p> </button>
          <div class="panel">
              <p class="pd1" onclick="location.href='/vcform'">결재 서류 작성</p>
              <c:if test="${lev==2 }">
              <p class="pd1" onclick="location.href='/watingmyapv'">내가결재받을것대기함<c:if test="${count1!=0}"><span id="c">${count1 }</span></c:if></p>
              </c:if>              	
                <p class="pd1" onclick="location.href='/watinglist'">결재대기함<c:if test="${count!=0}"><span id="c">${count }</span></c:if></p>
                <p class="pd1" onclick="location.href='/cflist'">결재완료함</p>
                <p class="pd1" onclick="location.href='/rejlist'">반려함</p>
          		
              
          </div>
  
          <button class ="aside-accordion"><p class="float-L"><i class="fas fa-columns"></i><p class="mobile-hidden">&nbsp&nbsp 사내메일</p><i class="fas fa-angle-down float-R"></i></p> </button>
          <div class="panel">
              <p class="pd1" onclick="location.href='/email/write'">메일 보내기</p>
             
              <p class="pd1" onclick="location.href='/email/receiveList'">받은메일함</p>
               <p class="pd1" onclick="location.href='/email/sendList'">보낸메일함</p>
                <p class="pd1" onclick="location.href='/email/deleteList'">삭제메일함</p>
              
  
          </div>
         
  
  <hr>  <hr>  <hr>
          <button class="aside-accordion"><p class="float-L"><i class="fas fa-sitemap"></i><p class="mobile-hidden">&nbsp&nbsp 게시판</p><i class="fas fa-angle-down float-R"></i></p> </button>

  		<div class="panel">
			<p class="pd1" onclick="location.href='organization'">공지게시판</p>
			<p class="pd1" onclick="location.href='eupdate'">자유 게시판</p>        
	
      
          </div>
          <button class="aside-accordion"><p class="float-L"><i class="far fa-envelope"></i><p class="mobile-hidden">&nbsp&nbsp 일정</p><i class="fas fa-angle-down float-R"></i></p></button>
          <div class="panel"  >
              <p class="pd1" onclick="location.href='@'">일정관리</p>
    
          </div>
          
          
          <button class="aside-accordion"><p class="float-L"><i class="far fa-envelope"></i><p class="mobile-hidden">&nbsp&nbsp 관리자</p><i class="fas fa-angle-down float-R"></i></p></button>
          <div class="panel"  >
              <p class="pd1" onclick="location.href='@'">회원등록</p>
    
          </div>
  
		 <script>
          
           
           $(document).ready(function(){
        	
        	   
        	   // 아코디언 메뉴 버튼을 클릭할 때 실행
        	   $(".aside-accordion").click(function(){
            	   $(".aside-accordion").removeClass("active"); 
        	       $(this).addClass("active");
        	       
        	       $(this).next().slideToggle(300);
        	       // $(this).next().slideDown(300);
        	       $(".aside-accordion").not(this).next().slideUp(300);
        	       
        	       return false;
        	   });
        	 });
          </script>
	
</aside>