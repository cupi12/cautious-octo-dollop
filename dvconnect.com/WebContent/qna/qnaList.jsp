<%@page import="com.dvconnect.qna.model.QnaVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글보기</title>
<script>
	function qnaInsert() {
		location.href = "QnaInsert.do"
	}
</script>
</head>
<%@include file="/common/header.jsp"%>
<body ailgn="center">
<div class="wrap">
	<div class="list_w">

	<h2>Q&A 게시판</h2>
	<button onclick="qnaInsert()">글등록</button>
	<form name="frm">
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>	
			<td>작성자</td>
			<td>작성일자</td>
		</tr>
		<c:forEach items="${qnaList }" var="vo">
			<tr>
				<td>${vo.seq }</td>
				<td><a href="QnaContents.do?seq=${vo.seq }">${vo.title }</a></td>
				<td>${vo.nickName }</td>
				<td><fmt:parseDate value="${vo.regdt }" var="fmtDt"
						pattern="yyyy-MM-dd" /> <fmt:formatDate value="${fmtDt}"
						 /></td>
		</c:forEach>
		</tr>
	</table>
	</form>
	<script type="text/javascript">
	function gopage(p){
		document.frm.p.value=p;
		document.frm.submit();
	}
	</script>
<my:paging paging="${paging }" jsfunc="gopage"/>
</div>
</div>
</body>
</html>