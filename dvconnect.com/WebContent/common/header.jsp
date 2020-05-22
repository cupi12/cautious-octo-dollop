<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width: 25%;
	height: 700px; /* only for demonstration, should be removed */
	background: #8FBD24;
	padding: 20px;
	text-align: center;
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

font.m_top {
	margin: 0 140px;
}

div.wrap {
	width: 75%;
	margin: 0 auto;
	float: left;
}

div.wrap .list_w {
	width: fit-content;
	margin-left: 47px;
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
	function memberInsert() {
		location.href = "MemberInsert.do";
	}
	function login() {
		location.href = "Login.do"
	}
	function googleSearch() {
		window.open('about:blank').location.href = "https://www.google.com/search?q="
				+ google.value;
	}
	function logout() {
		var result = confirm("정말 로그아웃 하시겠습니까?");
		if (result) {
			location.href = "Logout.do"
		}
	}
	function memberUpdate() {
		location.href = "MemberUpdate.do"
	}
</script>

<body>
	<header>
		<input type="text" id="google" name="google" placeholder="google검색">
		<button type="button" onclick="googleSearch()">검색</button>

		<font size="40" class="m_top">DV Connect.com</font>
		<%
			String loginId = (String) session.getAttribute("loginId");
		%>
		<%
			if (loginId == null) {
		%>
		<button type="button" onclick="login()">로그인</button>
		&nbsp;&nbsp;
		<button type="button" onclick="memberInsert()">회원가입</button>
		<br> <br>
		</h2>
		<%
			} else {
		%>
		<button type="button" onclick="location.href='Calendar.do'">일정관리</button>
		<button type="button" onclick="memberUpdate()">정보수정</button>
		<button type="button" onclick="logout()">로그아웃</button>
		<%
			}
		%>

	</header>

	<section>
		<nav>
			<ul>
				<li><a href="./">메인</a></li>
				<br>
				<br>
				<li><a href="QnaList.do">Q&A</a></li>
				<br>
				<br>
				<li><a href="CommunityList.do">커뮤니티</a></li>
				<br>
				<br>
				<li><a href="https://okky.kr/articles/columns" target="_blank">칼럼</a></li>
				<br>
				<br>
				<li><a href="Language.do">개발언어</a></li>
			</ul>
		</nav>