<%@page import="com.dvconnect.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<script>
function update() {
	alert("수정 완료!");
	frm.submit();
	}
</script>
</head>
<body>
<%@include file="/common/header.jsp"%>
<form name ="frm" action ="MemberUpdate.do" method="post">
<h2>회원정보 수정</h2>
아이디 : <input type="text" name="id" id="id" value="${vo.getId()}" readonly><br>
비밀번호 : <input type="password" name="pwd" id="pwd" value="${vo.getPwd()}" placeholder="패스워드"><br>
이메일 : <input type="text" name="email" id="email" value="${vo.getEmail()}" placeholder="이메일"><br>
닉네임 : <input type="text" name="nickName" id="nickName" value="${vo.getNickName()}" placeholder="닉네임"><br>
<button type="button" onclick="update()">수정</button>
</form>

</body>
</html>