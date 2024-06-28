<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>MOHAJIPOP!</title>
	<link rel="stylesheet" type="text/css" href="root/css/reset.css">
	<link rel="stylesheet" type="text/css" href="root/css/common.css">
	<link rel="stylesheet" type="text/css" href="root/css/sub_signup.css">
	<script src="root/js/common.js"></script>
</head>
<body>
	<header>
		<div class="inner_wrap">
			<h1><a href="main">MOHAJIPOP!</a></h1>
			<button id="btn_menu"><span class="blind">menu button</span></button>
			<div class="utility">
						<a href="loginPage"><span>로그인</span></a>
						<a href="signUpPage"><span>회원가입</span></a>
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

	<section class="signup">
		<h2>SIGN UP</h2>
		<div class="form_wrap">
			<form action="signUp" id="registerForm" method="post">
				<fieldset>
					<legend class="blind">account</legend>
					<div class="account">
						<input type="text" name="userId" id="user_id" placeholder="아이디" required>
						<button type="button" onclick="checkUsername()">중복확인</button><br>
						<label id="errorLabel" style="color: red; display: none;">${error}</label>
						<label id="checkLabel" style="color: blue; display: none;">${check}</label>
						<label id="checkLabel2" style="color: red; display: none;">아이디를 입력해 주세요</label>
						<input type="password" name="pass" id="user_pw" placeholder="비밀번호" required>
						<input type="password" name="user_pw_confirm" id="user_pw_confirm" placeholder="비밀번호 확인" required>
						<label id="passNotEquals" style="color: red; display: none;">비밀번호가 일치하지 않습니다.</label>
					</div>
				</fieldset>
				<fieldset>
					<legend class="blind">user information</legend>
					<div class="user_info">
						<input type="text" name="uname" id="user_name" placeholder="이름" required>
						<input type="email" name="email" id="user_mail" placeholder="이메일" required>
						<input type="tel" name="phoneNum" id="user_phone" placeholder="핸드폰번호" required>
						<input type="date" name="birth" id="user_birth" data-placeholder="생년월일" required>
						<div class="user_gender">
							<p>성별</p>
							<label for="user_gender_man">
								<input type="radio" name="gender" id="user_gender_man" value="male" data-placeholder="남자">
							</label><!--
						--><label for="user_gender_woman">
							<input type="radio" name="gender" id="user_gender_woman" value="female" data-placeholder="여자">
						</label>
						</div>
					</div>
					<div class="checkbox">
						<label for="agree_event"><input type="checkbox" name="uevent" id="agree_event">이벤트 수신 동의</label>
					</div>
					<label id="idNotCheck" style="color: red; display: none;">아이디 중복확인을 해주세요</label>
					<div id="emptyFieldError" style="display:none; color:red;">
						모든 필드를 입력해 주세요.
					</div>
				</fieldset>
				<button type="button" onclick="register()" class="btn_more _color_01 _bg_01 _L">회원가입</button>
<%--				<input type="submit" value="회원가입" class="btn_more _color_01 _bg_01 _L">--%>
			</form>
		</div>
	</section>
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
		//-------------아이디 체크시 실행되는 액션------------------
		function checkUsername() {
			//userId의 value 에서 공백을 제거한 값
			var userId = document.getElementById("user_id").value.trim();
			if (userId === "") {
				document.getElementById("checkLabel2").style.display = "block";
				document.getElementById("errorLabel").style.display = "none";
				document.getElementById("checkLabel").style.display = "none";
				document.getElementById("user_id").focus();
				return false;
			}
			var pass = document.getElementById("user_pw").value.trim();
			var email = document.getElementById("user_mail").value.trim();
			var uname = document.getElementById("user_name").value.trim();
			var phoneNum = document.getElementById("user_phone").value.trim();
			var birth = document.getElementById("user_birth").value.trim();

			var queryString = "?userId=" + encodeURIComponent(userId)
					+ "&pass=" + encodeURIComponent(pass)
					+ "&email="+ encodeURIComponent(email)
					+ "&phoneNum=" + encodeURIComponent(phoneNum)
					+ "&uname=" + encodeURIComponent(uname)
					+ "&birth="+ encodeURIComponent(birth);

			window.location.href = "userIdCheck" + queryString;
		}

		//---------회원가입 버튼을 눌렀을 경우 실행되는 코드-----------
		function register() {
			var userId = document.getElementById("user_id").value.trim();
			var pass = document.getElementById("user_pw").value.trim();
			var email = document.getElementById("user_mail").value.trim();
			var uname = document.getElementById("user_name").value.trim();
			var phoneNum = document.getElementById("user_phone").value.trim();
			var birth = document.getElementById("user_birth").value.trim();
			//패스워드가 같은지 확인후 같을 때만 회원가입 실행
			var password = document.getElementById("user_pw").value.trim();
			var confirmPassword = document.getElementById("user_pw_confirm").value.trim();
			if (password !== confirmPassword) {
				document.getElementById("passNotEquals").style.display = "block";
				return;
			} else {
				document.getElementById("passNotEquals").style.display = "none";
			}
			// 아이디 체크를 했을 경우
			if (document.getElementById("checkLabel").style.display === "block") {
				// 필드가 비어있지 않은지 확인
				if (!userId || !pass || !email || !uname || !phoneNum || !birth) {
					document.getElementById("emptyFieldError").style.display = "block";
					return;
				} else {
					document.getElementById("emptyFieldError").style.display = "none";
					document.getElementById("registerForm").submit(); // 폼 제출
				}
			} else {
				document.getElementById("idNotCheck").style.display = "block";
				return;
			}

		}
		//----------------오류 표시--------------------------
		// 페이지 실행시 아이디 중복일 경우 에러코드를 받아온다면 아래와 같이 오류표시
		function displayErrorMessage(error) {
			if (error) {
				document.getElementById("errorLabel").innerText = error;
				document.getElementById("errorLabel").style.display = "block";
			}
		}
		displayErrorMessage('${error}');

		//페이지 실행시 아이디가 중복이 아닐 경우 아래와 같이 체크 값을 받아 표시
		function displayCheckMessage(check) {
			if (check) {
				document.getElementById("checkLabel").innerText = check;
				document.getElementById("checkLabel").style.display = "block";
			}
		}
		displayCheckMessage('${check}');

		//----------------페이지 새로고침시 이전의 상태정보를 받아온다--------------------------
		//페이지 실행시 해당 값들이 있다면 해당하는 id 의 input 칸에 받아온 value를 넣는다.
		window.onload = function() {
			var userIdValue = "${userId}";
			var passValue = "${pass}";
			var emailValue = "${email}";
			var phoneValue = "${phoneNum}";
			var birthValue = "${birth}";
			var unameValue = "${uname}";

			if (userIdValue) {
				document.getElementById("user_id").value = userIdValue;
			}
			if (passValue) {
				document.getElementById("user_pw").value = passValue;
			}
			if (emailValue) {
				document.getElementById("user_mail").value = emailValue;
			}
			if (phoneValue) {
				document.getElementById("user_phone").value = phoneNumValue;
			}
			if (birthValue) {
				document.getElementById("user_birth").value = birthValue;
			}
			if (unameValue) {
				document.getElementById("user_name").value = unameValue;
			}
		};
	</script>
</body>
</html>