<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>MOHAJIPOP!</title>
	<link rel="stylesheet" type="text/css" href="root/css/reset.css">
	<link rel="stylesheet" type="text/css" href="root/css/common.css">
	<link rel="stylesheet" type="text/css" href="root/css/sub_mypage.css">
	<link rel="stylesheet" type="text/css" href="root/css/sub_mypage_mypopup.css">
	<link rel="stylesheet" type="text/css" href="root/css/sub_mypage_myreview.css">
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
					<script type="text/javascript">
						window.location.href = 'main';
					</script>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<nav>
		<ul>
			<li><a href="selectAllList">POPUP</a></li>
			<li><a href="#">MAP</a></li>
			<li><a href="#">EVENT</a></li>
		</ul>
	</nav>
</header>

<section class="visual">
	<h2>MY PAGE</h2>
</section>
<div class="content">
	<div class="conts_wrap">
		<div class="inner_wrap">
			<!--사이드바-->
			<aside>
				<div class="side_wrap">
					<h2 class="blind">side navigation</h2>
					<h3>MY PAGE</h3>
					<nav>
						<ul>
							<li class="active"><a onclick="showUserInfo()"><span>내 정보</span></a></li>
							<li><a onclick="showMyPopups()"><span>나의 팝업</span></a></li>
							<li><a onclick="showMyBoard()"><span>리뷰 관리</span></a></li>
							<li><a href="#"><span>스케줄</span></a></li>
						</ul>
					</nav>
				</div>
			</aside>
			<!--사이드바-->
			<div class="conts_wrap">
				<div id="userInfo">
				<section class="info_edit">

						<h2 class="blind">my information section</h2>
						<div class="form_wrap">
							<form id="registerForm" action="userUpdate" method="post">
								<fieldset>
									<legend class="blind">account</legend>
									<div class="account">
										<input type="text" name="userId" id="user_id" placeholder="아이디" required>
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
									</div>
									<div class="checkbox">
										<label for="agree_event"><input type="checkbox" name="uevent" id="agree_event">이벤트 수신 동의</label>
									</div>
									<label id="idNotCheck" style="color: red; display: none;">아이디 중복확인을 해주세요</label>
								</fieldset>
								<input type="button" onclick="register()" value="수정" class="btn_more _color_01 _bg_01 _L">
							</form>
						</div>

				</section>
				</div>

				<div id="myPopups" style="display: none;">
				<section class="mypopup">

						<h2>나의 팝업</h2>
						<div class="form_wrap">
							<fieldset>
								<legend class="blind">my popup</legend>
								<ul>
									<c:forEach var="myList" items="${myList}">
										<li>
											<a onclick="window.location.href='/view?popCode=${myList.popCode}';">
												<div class="img_wrap">
													<img src="<c:url value='${myList.rink}' />" alt="my popup list 01 image">
													<p>${myList.popName}</p>
												</div>
											</a>
											<form action="likeDelete" method="get">
												<input type="hidden" name="popCode" value="${myList.popCode}">
												<input type="hidden" name="userId" value="${userId}">
												<button type="submit" class="btn_delete"><span class="blind">delete button</span></button>
											</form>
										</li>
									</c:forEach>
								</ul>
							</fieldset>
						</div>
				</section>
				</div>

				<div id="myBoard" style="display: none;">
				<section class="myreview">

						<h2>리뷰 관리</h2>
						<div class="form_wrap">
							<fieldset>
								<legend class="blind">my popup</legend>
								<ul>
									<c:forEach var="board" items="${popBoard}">
										<li>
											<div class="score">
												<c:forEach begin="1" end="${board.star}">
													<i class="active star"><span class="blind">star icon</span></i>
												</c:forEach>
											</div>
											<div class="comment">
												<p class="user_id">${board.userId} ${board.content}</p>
											</div>
											<div class="user_write_date">
												<p>${board.regtime}</p>
											</div>
											<p hidden>${board.num}</p>
											<p hidden>${board.popCode}</p>
											<c:if test="${sessionScope.userId eq board.userId}">
												<button type="button" class="btn_delete" onclick="window.location.href='/delMyPopboard?num=${board.num}&popCode=${popCode}'"><span class="blind">delete button</span></button>
											</c:if>
										</li>
									</c:forEach>
								</ul>
							</fieldset>
						</div>
				</section>
				</div>
			</div>
		</div>
	</div>
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
		//---------회원가입 버튼을 눌렀을 경우 실행되는 코드-----------
		function register() {
			//패스워드가 같은지 확인후 같을 때만 업데이트 실행
			var password = document.getElementById("user_pw").value.trim();
			var confirmPassword = document.getElementById("user_pw_confirm").value.trim();
			if (password !== confirmPassword) {
				document.getElementById("passNotEquals").style.display = "block";
				return;
			} else {
				document.getElementById("passNotEquals").style.display = "none";
			}
			if (confirm("정말로 수정하시겠습니까?")) {
	            document.getElementById("registerForm").submit(); // 폼 제출
	        }
			}
		
		//----------------페이지 새로고침시 이전의 상태정보를 받아온다--------------------------
	  //페이지 실행시 해당 값들이 있다면 해당하는 id 의 input 칸에 받아온 value를 넣는다.
		    window.onload = function() {
		    showUserInfo();
			
		var userIdValue = "${user.userId}";
        var passValue = "${user.pass}";
        var emailValue = "${user.email}";
        var unameValue = "${user.uname}";
        var phoneValue = "${user.phoneNum}";
        var birthValue = "${user.birth}";
        var ueventValue = "${user.uevent}";

        if (userIdValue) {
            document.getElementById("user_id").value = userIdValue;
        }
        if (ueventValue) {
            document.getElementById("agree_event").checked = true;
        }
        if (unameValue) {
            document.getElementById("user_name").value = unameValue;
        }
        if (passValue) {
            document.getElementById("user_pw").value = passValue;
        }
        if (emailValue) {
            document.getElementById("user_mail").value = emailValue;
        }
        if (phoneValue) {
            document.getElementById("user_phone").value = phoneValue;
        }
        if (birthValue) {
            document.getElementById("user_birth").value = birthValue;
        }
        var popDelValue = "${popDel}"; // popDel 값 받아오기
        if (popDelValue === "on") { // popDel 값이 "on"인 경우
            showMyPopups(); // showMyPopups() 함수 실행
        }
        if (popDelValue === "off") { // popDel 값이 "on"인 경우
        	showMyBoard(); // showMyPopups() 함수 실행
        }
    };

    function showUserInfo() {
        document.getElementById("userInfo").style.display = "block";
        document.getElementById("myPopups").style.display = "none";
        document.getElementById("myBoard").style.display = "none";
    }

    function showMyPopups() {
        document.getElementById("userInfo").style.display = "none";
        document.getElementById("myPopups").style.display = "block";
        document.getElementById("myBoard").style.display = "none";
    }
    
    function showMyBoard() {
    	document.getElementById("userInfo").style.display = "none";
        document.getElementById("myPopups").style.display = "none";
        document.getElementById("myBoard").style.display = "block";
    }
	</script>
</body>
</html>