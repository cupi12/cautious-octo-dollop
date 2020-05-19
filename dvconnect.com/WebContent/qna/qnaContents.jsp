<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<script>
function back(){
	location.href="/QnaList.do";
}
function del(){
	location.href="QnaDelete.do?seq="+${vo.seq };
	alert("삭제완료");
}
</script>
</head>
<%@include file="/common/header.jsp"%>
<h2>게시글 조회</h2>
<button onclick="location.href='QnaUpdate.do?seq=${vo.seq }'">수정</button>
<button onclick="del()">삭제</button>
<button onclick="back()">목록</button><br>
<textarea rows="auto" cols="60%" name="title" id="title" readonly>${vo.title }</textarea><br>
<textarea rows="30%" cols="60%" name="contents" id="contents" readonly>${vo.contents }</textarea><br>
</body>
</html>