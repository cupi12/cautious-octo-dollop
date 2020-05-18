<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	background-color: #FFDF24;
	padding: 10px;
	text-align: center;
	font-size: 35px;
	color: black;
}

/* Create two columns/boxes that floats next to each other */
nav {
	float: left;
	width: 20%;
	height: 70%; /* only for demonstration, should be removed */
	background: #8FBD24;
	padding: 20px;
	text-align:center;
}

/* Style the list inside the menu */
nav ul {
	list-style-type: none;
	padding: 0;
}

article {
	float: left;
	padding: 20px;
	width: 70%;
	background-color: #f1f1f1;
	min-height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 600px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>
<script>
function memberInsert(){
	location.href="MemberInsert.do";
}
function login(){
	location.href="Login.do"
}
function googleSearch(){
	location.href="https://www.google.com/search?q=${google}";
}
function logout(){
	location.href="Logout.do"
}
</script>

<body>
	<header>
		<h2><input type="text" id="google" name="google" placeholder="google검색"> 
		<button type="button" onclick="googleSearch()">검색</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font size="40">DV Connect.com</font>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${loginId == null}">
<button type="button" onclick="login()">로그인</button>&nbsp;&nbsp;
<button type="button" onclick="memberInsert()">회원가입</button><br><br></h2>
</c:if>
<c:if test="${loginId != null }">
<button type="button" onclick="memberUpdate()">정보수정</button>
<button type="button" onclick="logout()">로그아웃</button>
</c:if>

	</header>

	<section>
		<nav>
			<ul>
				<li><a href="./">메인</a></li><br><br>				
				<li><a href="">Q&A</a></li><br><br>
				<li><a href="">커뮤니티</a></li><br><br>				
				<li><a href="">칼럼</a></li><br><br>
				<li><a href="">개발언어</a></li>
			</ul>
		</nav>

		