<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<script>
function back(){
	location.href="Main.do"	
}
</script>
</head>
<body align="center">
<form action ="Login.do" method="post">
<h2>로그인</h2>
<input type="text" id="id" name="id"><br>
<input type="text" id="pwd" name="pwd"> <br>
<button>로그인</button><br>
<button onclick="back()">메인화면</button>
</form>
</body>
</html>