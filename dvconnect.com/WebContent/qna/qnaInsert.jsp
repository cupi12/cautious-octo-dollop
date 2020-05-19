<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 등록</title>
<script>
function back(){
	location.href = "QnaList.do"
}
function validCheck(){
	if(frm.title.value ==""){
		alert("제목을 입력하세요.")
		return;
	}if(frm.contents.value ==""){
		alert("내용을 입력하세요.")
		return;
	}
}
</script>
</head>
<%@include file="/common/header.jsp"%>
<body>
<h2>Q&A 게시글 등록</h2>
<form name ="frm" action="QnaInsert.do" method="post">
<button type="button" onclick="validCheck()">작성완료</button>
<button type="button" onclick="back()">이전</button><br>
<textarea cols="60%"  id="title" name="title" placeholder="제목"></textarea><br>
<textarea rows="30%" cols="60%" id="contents" name="contents" placeholder="내용"></textarea>
</form>
</div>
</body>
</html>