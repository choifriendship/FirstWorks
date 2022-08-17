<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <!-- <link rel="stylesheet" href="css/style.css"> -->  
  <style>
 *{margin: 0; padding: 0;
  font-family: 'LeferiPoint-WhiteObliqueA';}
@font-face {
  font-family: 'LeferiPoint-WhiteObliqueA';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-WhiteObliqueA.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
#super{
  width: 100vw; height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
#container{ 
  width: 700px; 
  height: 850px; 
  
}
header{
  width: 100%; height: 20%;

  background-color: #999AFE;
}
#title{
  display: flex;
  justify-content: center;
  align-items: center;
  float: left;
  width: 40%; height: 100%;
  /* background-color: blue; */
}
#logo{
  
}
#con1{  
  width: 100%; height: 40%;
  /* background-color: blueviolet; */
}
.con{
  border-radius: 15px;
  position: relative;
  margin-top: 10px;
  margin-right: 9px;
  padding: 15px;
  float: right;
  text-decoration: none;
  /* border: 1px solid gray; */
  color: white;
  background-color: chocolate;
  transition: 0.5s;
}
.con:hover{
  color: black;
  background-color: white;
}
#con2{  
  width: 100%; height: 60%;
  /* background-color: bisque; */
}
#stamp{ 
  margin-right: 5px;
  margin-top: 4px;
  float: right;
  width: 25%; height: 90%; 
}
#seal{
  width: 100%; height: 70%;
}
#who{
  text-align: center;
  background-color: skyblue;
  border-radius: 7px;
}
#confirm{
  float: right;
  width: 60%; height: 100%;
  /* background-color: brown; */
}
aside{
  width: 100%; height: 20%;
  /* background-color: aliceblue; */
}
#date{
  display: flex;
  align-items: center;
  width: 100%; height: 30%;
  /* background-color: darkmagenta; */
}
#date1{
  font-size: 1.5em;
}
#no{
  width: 100%;height: 40%;
}
#left{
  float: left;
  width: 50%; height: 100%;
  /* background-color: darkorange; */
}
#right{
  float: right;
  width: 50%; height: 100%;
  /* background-color:goldenrod; */
}
.aa{
  line-height: 2;
}
#doct{
  display: flex;
  align-items: center;
  width: 100%; height: 30%;
  /* background-color: dodgerblue;     */
}
#doct2{
  height: 25px;
}
textarea{
  width: 99.7%; height: 400px;
}
footer{
  width: 100%; height: 10%;
  /* background-color: fuchsia; */
}
#fooleft{
  display: flex;
  align-items: center;
  float: left;
  width: 50%; height: 100%;
  /* background-color: ghostwhite; */
}
#fooright{
  display: flex;
  align-items: center;
  float: right;
  width: 50%; height: 100%;
  /* background-color: khaki; */
}
#file{
  float: right;
}
#seal{
	width:100%; height: 65%;
	border-radius: 300px; 
}
  </style>
</head>
<body>
  <c:if test="${lev==1 }">
  <form action="/vcpro" method="post">
  </c:if>
  <c:if test="${lev==2 }">
  <form action="/vcprotwo" method="post">
  </c:if>
  <c:if test="${lev==3 }">
  <form action="/vcprothree" method="post">
  </c:if>
  <div id="super">
    <!-- 컨테이너 -->
    <div id="container">
      <!-- 헤더 -->
      <header>
        <div id="title">
          <h1 id="logo">휴가신청서</h1>
        </div>
        <div id="confirm">
          <div id="con1">
            <a href="#" class="con">결재선</a><a href="#" class="con">임시저장</a><a href="#" class="con">수정</a><a href="#" class="con" onclick="submit();">결재</a>
          </div>
          <div id="con2">
            <img id="seal" src="http://localhost:8080/image/<c:if test="${list. mem_stamp_three!=null}">${list.mem_stamp_three }</c:if>">              <!-- 도장 -->
              <p id="who">부장</p>				<!-- src 부장 -->
            </div>
            <div id="stamp">
              <img id="seal" src='http://localhost:8080/image/<c:if test="${list. mem_stamp_two!=null}">${list.mem_stamp_two }</c:if>'>			<!-- 도장 -->
              <p id="who">팀장</p>				<!-- src 팀장 -->
            </div>
            <div id="stamp">
              <img id="seal" src="http://localhost:8080/image/<c:if test="${list. mem_stamp_one!=null}">${list. mem_stamp_one}</c:if>">				<!-- 도장 -->
              <p id="who">본인</p>				<!-- src 본인 -->
            </div>           
          </div>
        </div>
      </header>
      <!-- 어사이드 -->
      <aside>
        <div id="date">
          <p id="date1">휴가날짜:<span id="datein"></span><input name="apv_vc_str_dt" type="date"> 부터 <input type="date" name="apv_vc_end_dt"> 까지</p>
        </div>
        <div id="no">
          <div id="left" class="aa">
            <p>문서번호:<span id="docno">${list.apv_no }</span><!-- <input type="text" name="docno"> --></p>
            <p>기안자:<span id="writer"></span></p>
          </div>
          <div id="right" class="aa">
            <p>기안부서:<span id="deptname"></span><!-- <input type="text" name="deptname"> --></p>
            <p>기안일자:<span id="nowdate"></span><!-- <input type="date" name="nowdate"> --></p>
          </div>
        </div>
        <div id="doct">
          <h1>문서제목:<span id="doct1">${list.apv_vc_tit }</span></h1><input type="text" name="apv_vc_tit" id="doct2">
        </div>
      </aside>
      <!-- 메인 -->
      <main>
        <textarea name="apv_vc_txt" placeholder="본문내용">${list.apv_vc_txt }</textarea>
      </main>
      <!-- 푸터 -->
      <footer>
        <div id="fooleft">
          <p>파일첨부</p>
        </div>
        <div id="fooright">
          <!-- <input type="file" id="file"> -->
        </div>
      </footer>   
	
   </div>
  </div>
  <input type="submit" value="결재">
</form>

</body>
</html>