<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>memberInsert</title>
<script>
function validCheck(){
	if(frm.id.value ==""){
		alert("아이디를 입력하세요.");
		frm.id.focus();
		return;
	}if(frm.pwd.value ==""){
		alert("패스워드를 입력하세요.");
		frm.pwd.focus();
		return;
	}if(frm.email.value ==""){
		alert("이메일을 입력하세요.");
		frm.email.focus();
		return;
	}if(frm.nickName.value ==""){
		alert("닉네임을 입력하세요.");
		frm.nickName.focus();
		return;
	}
	frm.submit();
}
</script>
</head>
<body align="center" colspan="50%" rowspan="50%">
<form  name="frm" action ="MemberInsert.do" method="post"> 
<br><br>
<h2>회원가입</h2><br>
<input type="text" name="id" id="id" placeholder="아이디"><br>
<input type="text" name="pwd" id="pwd" placeholder="패스워드"><br>
<input type="text" name="email" id="email" placeholder="이메일"><br>
<input type="text" name="nickName" id="nickName" placeholder="닉네임"><br>
<button type="button" onclick="idCheck()">ID중복확인</button><br>
<button type="button" onclick="validCheck()"> 회원가입</button>
</form>

</body>
</html>