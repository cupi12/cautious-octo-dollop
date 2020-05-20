<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
function update(){
	alert("일정수정 완료!");
	frm.submit();
}
</script>
</head>
<body align="center">



<h2>일정조회</h2><br>
<form name="frm" method="post">
<fmt:parseDate value="${param.calendarDate }" pattern="yyyyMMdd" var="date"/>
날짜 : <input type="text" name="calendarDate" id="calendarDate" value ="<fmt:formatDate pattern="yyyy-MM-dd" value='${date}'/>" readonly><br>
일정 : <input type="text" name="schedule" id="schedule" value="${vo.getSchedule() }"><br><br>
<button onclick="update()">수정</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="window.close()">닫기</button>
</form>
</body> 
</html>