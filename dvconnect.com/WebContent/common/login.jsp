<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인페이지</title>
<script>

function login(){
	alert("환영합니다");
	frm.submit();
}
</script>
</head>
<body align="center">
<form action ="Login.do" method="post" name="frm">
<h2>로그인</h2>
<input type="text" id="id" name="id" placeholder="아이디"><br>
<input type="password" id="pwd" name="pwd" placeholder="패스워드"> <br>
<button onclick="login()">로그인</button><br>
</form>
<button type="button" onclick="location.href='Main.do'">메인화면</button>
</body>
</html>