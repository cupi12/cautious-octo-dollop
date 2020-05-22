<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>memberInsert</title>
<script>
function validCheck(){
	if(frm.id.value ==""){
		alert("아이디를 입력하세요.");
		frm.id.focus();
		return;
	}if(frm.pwd.value ==""){
		alert("패스워드를 입력하세요.");
		frm.pwd.focus();
		return;
	}if(frm.email.value ==""){
		alert("이메일을 입력하세요.");
		frm.email.focus();
		return;
	}if(frm.nickName.value ==""){
		alert("닉네임을 입력하세요.");
		frm.nickName.focus();
		return;
	}
	frm.submit();
}
function idDupCheck() {
	//1.xhr 객체를 생성한다.
	var xhttp = new XMLHttpRequest();
	//2. onreadystatechange가 발생하면 function을 수행하라. 콜백 함수를 지정해줌.
	xhttp.onreadystatechange = function() { //fuction() =>콜백함수
		if (this.readyState == 4) {//응답 완료
			//getElementById() 태그에 id값을 넣어야함.여기선 <span id="result">값을 넣어줌
			if (this.status == 200) {//정상실행
				console.log("ajax 요청 완료");
				document.getElementById("result").innerHTML = this.responseText;
			} else {
				document.getElementById("result").innerHTML = this.status + this.statusText;
			}
		} else {
			//readyState가 4가 아니면, 로딩중 이미지를 출력
			document.getElementById("result").innerHTML = "ID 확인중...";
		}
	};
	//3. 서버 연결  "get"방식, "서버요청주소"
	var param = "id=" + document.frm.id.value;
	xhttp.open("POST", "IdDupCheck.do", true); //true = 비동기식 false = 동기식     *(비동기 여부를 물어봄)
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	//4. 서버 전송
	xhttp.send(param);
	console.log("ajax 요청 시작");
}
</script>
</head>
<body align="center" colspan="50%" rowspan="50%" background="WebContent/common/alberta-2297204_1920.jpg"">
<form  name="frm" action ="MemberInsert.do" method="post"> 
<br><br>
<h2>회원가입</h2><br>
<span id="result"></span><br>
<input type="text" name="id" id="id" placeholder="아이디" onchange="idDupCheck()"><br>
<input type="text" name="pwd" id="pwd" placeholder="패스워드"><br>
<input type="text" name="email" id="email" placeholder="이메일"><br>
<input type="text" name="nickName" id="nickName" placeholder="닉네임"><br>
<button type="button" onclick="validCheck()"> 회원가입</button><br>
<button type="button" onclick="location.href='Main.do'">메인화면</button>
</form>

</body>
</html>