<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/loginform.css" />
<title>Insert title here</title>
</head>
<body>
    <div class="wrap">
        <div class="login">
            <h2>Log-in</h2>
            <div class="login_sns">
            <li><a href=""><i class="fab fa-instagram"></i></a></li>
            <li><a href=""><i class="fab fa-facebook-f"></i></a></li>
            <li><a href=""><i class="fab fa-twitter"></i></a></li>
            </div>
  			<form method="post" action="/login/login">
            <div class="login_id">
                <h4>E-mail</h4>
                <input type="text" name="mem_id" id="mem_id" placeholder="사원아이디">
            </div>
            <div class="login_pw">
                <h4>Password</h4>
                <input type="password" name="mem_pw" id="mwm_pw" placeholder="사원비밀번호">
            </div>
            <div class="login_etc">
                <div class="checkbox">
                <input type="checkbox" name="Checkid" id="Checkid"> Remember Me?
                </div>
                <div class="forgot_pw">
                <a href="">Forgot Password?</a>
            </div>
            </div>
            <div class="submit">
                <input type="submit" value="submit">
            </div>
  </form>
        </div>
    </div>

</body>
</html>