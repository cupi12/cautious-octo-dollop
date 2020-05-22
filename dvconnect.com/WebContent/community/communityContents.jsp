<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<script>
function back(){
	location.href="/CommunityList.do";
}
function del(){
	location.href="CommunityDelete.do?seq="+${vo.seq };
	alert("삭제완료");
}
</script>
</head>
<body>
<%@include file="/common/header.jsp"%>
<div class="wrap">
	
<div class="list_w">
<h2>게시글 조회</h2>
<c:if test="${vo.getId() == loginId or loginId=='admin' }">
<button onclick="location.href='CommunityUpdate.do?seq=${vo.seq }'">수정</button>
<button onclick="del()">삭제</button>
</c:if>
<button onclick="back()">목록</button><br>
<textarea rows="auto" cols="60%" name="title" id="title" readonly>${vo.title }</textarea><br>
<textarea rows="30%" cols="60%" name="contents" id="contents" readonly>${vo.contents }</textarea><br>
</div></div>
</body>

</html>