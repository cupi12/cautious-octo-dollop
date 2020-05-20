<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@include file="/common/header.jsp"%>
<body align="center">
<br><br>
<h2>일정 추가</h2>
<form action ="CalendarInsert.do" method="post">
날짜 : <input type="text" id="calendarDate" name="calendarDate" placeholder="YYYY/MM/DD"><br>
일정 : <input type="text" id="schedule" name="schedule"><br>
<button onclick="location.href='Calendar.do'">추가</button>
</form>
</body>
</html>