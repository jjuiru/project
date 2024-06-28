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
	<link rel="stylesheet" type="text/css" href="root/css/sub_popup.css">
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
			<li><a href="selectAllList">POPUP</a></li>
			<li><a href="#">MAP</a></li>
			<li><a href="#">EVENT</a></li>
		</ul>
	</nav>
</header>
<section class="content">
	<div class="inner_wrap_02">
		<h2 class="blind">popup search section</h2>
		<div class="search">
			<h3 class="blind">search box</h3>
			<form action="keyword" method="GET">
				<div class="search_input_box">
					<input type="search" name="keyword" id="insearch" maxlength="255" autocomplete="off" class="search_input" data-atcmp-element><!--
         --><button type="submit" class="btn_search">
					 <span class="ico_btn_search">
                <svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="none"><path fill="#666" fill-rule="evenodd" d="M17.95 9.608a8.342 8.342 0 1 1-16.684 0 8.342 8.342 0 0 1 16.684 0Zm-2.1 6.95a9.342 9.342 0 1 1 .707-.707l6.083 6.082-.707.707-6.082-6.082Z" clip-rule="evenodd"/></svg>
                <span class="blind">search button</span>
              </span>
				</button>
				</div>
			</form>
		</div>

		<form action="selectDate" method="GET">
			<input type="date" id="findPop" name="date">
			<button type="submit">날짜로 검색</button>
		</form>
		<div class="date terms">
			<h3>날짜</h3>
			<ul class="clearfix">
				<li class="active"><button>오늘</button></li>
				<li><button>+7일</button></li>
				<li><button>+2주</button></li>
				<li><button>직접설정</button></li>
			</ul>
		</div>
		<div class="location terms">
			<h3>지역</h3>
			<ul class="clearfix">
				<li class="active"><button onclick="window.location.href='selectAllList';">전체</button></li>
				<li><button>서울특별시</button></li>
				<li><button>경기도</button></li>
				<li><button>인천광역시</button></li>
				<li><button>부산광역시</button></li>
				<li><button>대전광역시</button></li>
			</ul>
		</div>
		<div class="ongoing">
			<h3>진행중</h3>
			<h1><a>${text}</a></h1>

			<ul class="clearfix" >
				<c:forEach var="list" items="${list}">
				<li onclick="window.location.href='/view?popCode=${list.popCode}';"
					style="cursor: pointer;">
					<div class="img_wrap">
						<a href="#"><img src="<c:url value='${list.rink}' />" alt="pop-up list image - tws: popup store"></a>
					</div>
					<div class="info_wrap">
						<h4><a href="#">${list.popName}</a></h4>
						<p class="local">${list.place}</p> <br><br>
						<p class="when">${list.startDay}-${list.endDay}</p>
					</div>
				</li>
				</c:forEach>
			</ul>

		</div>
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







</body>
</html>