<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Main Page</title>
<%@include file="/common/header.jsp"%>
<div class="wrap">
	<div class="list_w">
	<h1>메인페이지</h1>게시판 미리보기
<a href="QnaList.do"><h2>Q&A</h2></a>
<br>

<form name="frm" action="QnaList.do">
	<input name="p" value="1" type="hidden">
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
		</tr>
		</c:forEach>
	</table>
	</form>
<br>
<hr>
<br>
<a href="CommunityList.do"><h2>Community</h2></a>
<form name="frm" action="CommunityList.do">
	<input name="p" value="1" type="hidden">
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>	
			<td>작성자</td>
			<td>작성일자</td>
		</tr>
		<c:forEach items="${communityList }" var="vo">
			<tr>
				<td>${vo.seq }</td>
				<td><a href="CommunityContents.do?seq=${vo.seq }">${vo.title }</a></td>
				<td>${vo.nickName }</td>
				<td><fmt:parseDate value="${vo.regdt }" var="fmtDt"
						pattern="yyyy-MM-dd" /> <fmt:formatDate value="${fmtDt}"
						 /></td>
		</tr>
		</c:forEach>
	</table>
	</form>

</div>
</div>
</body>
</html>