<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MOHAJIPOP!</title>
  <link rel="stylesheet" type="text/css" href="root/css/reset.css">
  <link rel="stylesheet" type="text/css" href="root/css/common.css">
  <link rel="stylesheet" type="text/css" href="root/css/sub_login.css">
  <script src="root/js/common.js"></script>
</head>
<body>
	<header>
		<div class="inner_wrap">
			<h1><a href="main">MOHAJIPOP!</a></h1>
			<button id="btn_menu"><span class="blind">menu button</span></button>
			<div class="utility">
			<c:choose>
	<c:when test="${loginC}">
		<span>${userId}님.로그인</span> 
		<a href="myPage"><span>마이페이지</span></a>
		<a href="logout"><span>로그아웃</span></a>
		 </c:when>
		 <c:otherwise>
			<a href="loginPage"><span>로그인</span></a>
			<a href="signUpPage"><span>회원가입</span></a>
			
			    </c:otherwise>
				</c:choose>
			</div>
		</div>
		<nav>
			<ul>
				<li><a href="root/sub_popup.html">POPUP</a></li>
				<li><a href="#">MAP</a></li>
				<li><a href="#">EVENT</a></li>
			</ul>
		</nav>
	</header>
	<section class="login">
	    <h2>LOGIN</h2>
	    		<div class="form_wrap">
	<form action="login" method="post" onsubmit="return validateForm()">
					<fieldset>
					<legend class="blind">login</legend>	
		<input type="text" name="userId" id="user_id" placeholder="아이디">
	    <label id="userIdError" style="color: red; display: none;">아이디를 입력해주세요.</label>


		<input type="password" name="pass" id="user_pw" placeholder="비밀번호" style = margin-top:20px>
		<label id="passError" style="color: red; display: none;">비밀번호를 입력해주세요.</label>
		<label id="loginError" style="color: red; display: none;">아이디나 비밀번호가 올바르지 않습니다.</label> 
		<label id="errorLabel" style="color: red; display: none;">${error}</label>

	<label for="remember_id">
	<input type="checkbox" name="rememberId" id="remember_id">아이디 기억하기</label>
		</fieldset>
		
		<div class="btn_wrap">
		<input type="submit" value="LOGIN" class="btn_more _color_04 _bg_04">
		<a href="signUpPage" class="btn_more _color_04 _bg_04">SIGN UP</a>
		</div>
	</form>
	</div>
		<a href="main" class="btn_more _color_01 _bg_01 _L">MAIN</a>
  </section>
	<div>
		<button style="border-radius: 10px;"
			class="btn btn-sm btn-outline-secondary w-100 py-2"
			onclick="location.href='main'">main</button>
	</div>
	  <footer>
		<div class="inner_wrap clearfix">
			<p class="c_name">MOHAJIPOP!</p>
			<div class="footer_nav">
				<a href="#"><strong>Pravicy Policy</strong></a><!-- 
		 --><a href="#">Terms</a><!-- 
		 --><a href="#">Family Site</a><!-- 
		 --><a href="#">Site Map</a><!-- 
		 --><a href="#" target="_blank">Contact</a>
			</div>
			<div class="address">
				<address>서울 마포구 신촌로 176 중앙빌딩</address>
				<address>Jungang Building, 176, Sinchon-ro, Mapo-gu, Seoul</address>
			</div>
			<p class="copy">ⓒ 2024. MOHAJIPOP. All rights reserved.</p>
		</div>
	</footer>

	<script>
		function validateForm() {
			var userId = document.getElementById("user_id").value;
			var pass = document.getElementById("user_pw").value;

			if (userId.trim() === "") {
				document.getElementById("userIdError").style.display = "block";
				document.getElementById("user_id").focus();
				return false;
			} else {
				document.getElementById("userIdError").style.display = "none";
			}

			if (pass.trim() === "") {
				document.getElementById("passError").style.display = "block";
				document.getElementById("user_pw").focus();
				return false;
			} else {
				document.getElementById("passError").style.display = "none";
			}
			return true;
		}
	</script>
	<script>
		/* 서버로부터 받은 에러 메시지를 확인하여 표시하는 함수 */
		function displayErrorMessage(error) {
			// 에러 메시지가 존재하는 경우
			if (error) {
				// 에러 메시지를 표시하는 요소를 찾아서 에러 메시지를 설정하고, display 속성을 변경하여 표시합니다.
				document.getElementById("errorLabel").innerText = error;
				document.getElementById("errorLabel").style.display = "block";
			}
		}

		// 서버로부터 받은 에러 메시지를 확인하여 표시합니다.
		displayErrorMessage('${error}');
	</script>
</body>
</html>