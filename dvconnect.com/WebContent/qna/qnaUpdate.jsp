<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
</head>
<script>
function back(){
	location.href = "QnaList.do"
}
</script>
<body>
<%@include file="/common/header.jsp"%>
<form action="QnaUpdate.do" method="post">
<input type="hidden" name="seq" value="${vo.seq }">
<textarea rows="auto" cols="60%" name="title" id="title">${vo.title }</textarea><br>
<textarea rows="30%" cols="60%" name="contents" id="contents">${vo.contents }</textarea><br>
<button>수정완료</button>
<button onclick="back()">목록</button>
</form>
</body>
</html>