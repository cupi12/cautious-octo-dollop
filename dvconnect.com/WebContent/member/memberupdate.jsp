<%@page import="com.dvconnect.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<body>
<form action ="../MemberUpdate.do" method="post">
<%MemberVO vo = (MemberVO)request.getAttribute("vo");  %>
아이디 : <input type="text" name="id" id="id" value="<%vo.getId(); %>" readonly><br>
비밀번호 : <input type="text" name="pwd" id="pwd" value="<%vo.getId(); %>" placeholder="패스워드"><br>
이메일 : <input type="text" name="email" id="email" value="<%vo.getId(); %>" placeholder="이메일"><br>
닉네임 : <input type="text" name="nickName" id="nickName" value="<%vo.getId(); %>" placeholder="닉네임"><br>
</form>

</body>
</html>