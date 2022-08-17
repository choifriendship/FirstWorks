<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	   .con{
  border-radius: 15px;
  position: relative;  
  padding: 15px;
  float: right;
  text-decoration: none;
  border: 1px solid chocolate; 
  color: white;
  background-color: chocolate;
  transition: 0.5s;
}
.con:hover{
  color: black;
  background-color: white;
   border: 1px solid white;
}
#brej{	
	  display:none;
	  position: fixed;
      top: 0; left: 0; bottom: 0; right: 0;
      background: rgba(0,0,0,0.8);
}
#rej{
            display: block;
            position: fixed;
            top: calc(50vh - 300px); left: calc(50vw - 200px);
            background-color: #999AFE;            
            border-radius: 10px;
            width: 400px;
            height: 600px;             
            
        }
        #b{
            display: flex;
            justify-content: center; align-items: center;
        }
        #cus{
            width: 90%; height: 440px;
        }
        #b1{
            margin-top: 20px;
            display: flex;
            justify-content: center; align-items: center;
        }
  #mdiv{      
      width: 100%;
      background-color: #999AFE;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    #mimg{
      margin-top: 20px;
      width: 150px; height: 150px;
      background-color: white;
      border-radius: 100px;
    }
    #mname{
      width: 100%;
      background-color: #999AFE;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    #wrap{
      display: flex;
      width: 100%;
      flex-wrap: wrap;
    }
    .box{   
      border-radius: 15px;  
      align-items: center;
      width: 80%;
      margin: 10px;
      padding: 5px;
      background-color: white;
    }
    .boxx{   
      border-radius: 15px;    
      align-items: center;
      width: 90%;
      margin: 10px;
      padding: 10px;
      background-color: beige;
    }
    .bbox{      
      display: flex;
      justify-content: center;
      align-items: center;
      width: 80%;
      margin: 10px;
      padding: 10px;
      background-color: aqua;
    }
    .box1{
      width: 35%;
      margin: 10px;
      padding: 5px;
      /* background-color: aliceblue; */
    }
    .box2{
      border-radius: 15px; 
      text-align: center;
      width: 40%;
      margin: 10px;
      padding: 5px;
      /* background-color: aliceblue; */
    }
    .box3{     
      border-radius: 15px;  
      width: 5%;
      margin: 10px;
      padding: 5px;
      /* background-color: aliceblue; */
    }
    .box4{           
      width: 300px;      
      /* background-color: aliceblue; */
    }
    #mfile{
      display: none;
    }
    #upload{
      margin-left: 60px;
    }
    #upload1{
      position: relative;
      right: 50px;
    }
    #mstamp{
    position:absolute;
    top: calc(50vh - 100px); left: calc(50vw - 100px);
    display:none;
      background-color: #999AFE;            
            border-radius: 10px;
            width: 200px;
            height:200px;  
    }
    #stampimg{    
    width: 100%; height: 100%;
    border-radius: 10px;
    
    }
</style>
</head>
<body>
<div id="rej">
		      <!-- 이름  사진    -->      
		      <div id="mdiv">
		        <img id="mimg" src="http://localhost:8080/image/person.png" alt="#">
		      </div>
		      <div id="mname">
		        <p>${list.mem_nm }</p>
		      </div>   
		    <div id="wrap">
		        <!-- 이메일 -->
		      <div id="wrap" class="box">
		        <div class="box1">
		          이메일
		        </div>
		        <div class="box1">
		          ${list.mem_eml }
		        </div>
		      </div>
		      <!-- 입사일 -->
		      <div id="wrap" class="box">
		        <div class="box1">
		          입사일
		        </div>
		        <div class="box2">
		          <fmt:formatDate value="${list.mem_ent }" pattern="yyyy년 MM월 dd일" />
		        </div>
		      </div>
		      <!-- 결재도장업로드 -->
		      <div class="boxx">
		      <form action="/stampupload" method="post" enctype="multipart/form-data">         
		          <input class="con" id="upload" type="submit" value="도장업로드">     
		          <label for="mfile" id="upload1" class="con">도장이미지선택</label>      
		          <input  id="mfile" type="file" name="uploadFile" accept="image/*" required="required">        
		      </div>
		      <!-- 접기 -->
		      <div id="wrap" class="box">        
		        <div class="box1">
		          <a href="/main" class="con">메인</a>
		        </div>
		        <div class="box1">
		          <input class="con" type="button" value="도장보기" onclick="aaa()">
		        </div>        
		      </div>
		    </form>
		     </div>      
		    </div>
		<div id="brej">   
		    
		    <div id="mstamp">
		      <img id="stampimg" src="http://localhost:8080/image/<c:choose><c:when test="${list.mem_stamp!=null }">${list.mem_stamp} </c:when><c:otherwise>alt.jpg</c:otherwise></c:choose>" alt="#">
		      <input type="button" value="접기" class="con" onclick="bbb()"/>	 
		    </div>
  		</div>		
<script type="text/javascript">
function aaa(){        	    
    document.querySelector("#mstamp").style.display = 'block';   
    document.querySelector("#brej").style.display = 'block'; 
        
}
function bbb(){        	  
    document.querySelector("#mstamp").style.display = 'none';
    document.querySelector("#brej").style.display = 'none'; 
}

</script>
</body>
</html>