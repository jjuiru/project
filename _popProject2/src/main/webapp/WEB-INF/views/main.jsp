<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MOHAJIPOP!</title>
	<link rel="stylesheet" type="text/css" href="root/css/reset.css">
	<link rel="stylesheet" type="text/css" href="root/css/common.css">
	<link rel="stylesheet" type="text/css" href="root/css/index.css">
	<script src="root/js/common.js"></script>
	<script src="root/js/index.js"></script>
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
	<section class="visual">
		<h2 class="blind">visual section</h2>
		<div class="slides cur" data-index="1">
			<img src="root/images/img_index_visual_01.jpg" alt="MOHAJIPOP brand visual image">
			<div class="info_wrap">
				<p class="blind title">MOHAJIPOP!</p>
				<p class="desc">서울 팝업 전시 모두 모여라!</p>
			</div>
		</div>
		<div class="slides next" data-index="2">
			<img src="root/images/img_index_visual_02.jpg" alt="TWS: POPUP STORE visual image">
			<div class="info_wrap">
				<p class="title">TWS:<br>POP-UP STORE</p>
				<p class="desc">THE HYUNDAI STORE<br>B2 ICONIC SQUARE</p>
				<a href="/view?popCode=a01" class="btn_more _L _color_02 _bg_02">MORE</a>
			</div>
		</div>
		<div class="slides prev" data-index="3">
			<img src="root/images/img_index_visual_03.jpg" alt="PLAVE POPUP STORE visual image">
			<div class="info_wrap">
				<p class="title">PLAVE<br>POP-UP STORE</p>
				<p class="desc">THE HYUNDAI STORE<br>F5 FLOOR</p>
				<a href="/view?popCode=a04" class="btn_more _L _color_03 _bg_03">MORE</a>
			</div>
		</div>
		<div class="pagination">
			<button class="active"><span><span class="blind">visual slide 01</span></span></button><!-- 
		 --><button><span><span class="blind">visual slide 02</span></span></button><!-- 
		 --><button><span><span class="blind">visual slide 03</span></span></button>
		</div>
	</section>
	<div class="conts_wrap">
		<div class="inner_wrap">
			<aside>
				<div class="side_wrap">
					<h2 class="blind">side section</h2>
					<div class="favored">
						<h3>인기 TOP 전시</h3>
						<div class="view_mask">
							<ul class="clearfix">
								<li>
									<a href="/view?popCode=a01">
										<img src="root/images/img_index_aside_favored_01.jpg" alt="TWS: POP-UP STORE">
									</a>
									<h4>TWS: POP-UP STORE</h4>
								</li>
								<c:forEach var="list" items="${artlist}" begin="1" end="4">
								<li >
									<a href="/view?popCode=${list.popCode}">
										<img src="<c:url value='${list.rink}' />" alt="pop mini img">
									</a>
									<h4>${list.popName}</h4>
								</li>
								</c:forEach>
							</ul>
						</div>
						<button class="dir_btn prev _M _bg_BK"><span><span class="blind">prev button</span></span></button>
						<button class="dir_btn next _M _bg_BK"><span><span class="blind">next button</span></span></button>
					</div>
					<div class="calendar">
						<div class="calendar">
						    <div class="cal_wrap">
						        <div class="header_wrap">
						            <div class="nav">
						                <button class="dir_btn prev _S _bg_BK"><span><span class="blind">prev button</span></span></button>
						                <p class="cur_month"></p>
						                <button class="dir_btn next _S _bg_BK"><span><span class="blind">next button</span></span></button>
						            </div>
						        </div>
						        <div class="body_wrap">
						            <ul class="weeks">
						                <li>일</li>
						                <li>월</li>
						                <li>화</li>
						                <li>수</li>
						                <li>목</li>
						                <li>금</li>
						                <li>토</li>
						            </ul>
						            <ul class="days">
						                <!-- 여기에 날짜를 추가할 예정 -->
						            </ul>
						        </div>
						    </div>
						</div>

						<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
						<script>
						    $(document).ready(function() {
						        var currentDate = new Date();
						        var currentYear = currentDate.getFullYear();
						        var currentMonth = currentDate.getMonth();

						        // 초기 달력 렌더링
						        renderCalendar(currentYear, currentMonth);

						        // 이전 달과 다음 달 버튼 이벤트 처리
						        $('.prev').click(function() {
						            currentMonth--;
						            if (currentMonth < 0) {
						                currentMonth = 11;
						                currentYear--;
						            }
						            renderCalendar(currentYear, currentMonth);
						        });

						        $('.next').click(function() {
						            currentMonth++;
						            if (currentMonth > 11) {
						                currentMonth = 0;
						                currentYear++;
						            }
						            renderCalendar(currentYear, currentMonth);
						        });

						        // 날짜를 동적으로 추가하는 함수
						        function renderCalendar(year, month) {
						            var daysList = $('.days');
						            daysList.empty();

						            var daysInMonth = new Date(year, month + 1, 0).getDate();
						            var firstDay = new Date(year, month, 1).getDay();

						            $('.cur_month').text((month + 1) + '월');

						            // 1일 이전의 빈 칸 채우기
						            for (var i = 0; i < firstDay; i++) {
						                daysList.append('<li class="inactive"></li>');
						            }

						            // 날짜 채우기
						            for (var day = 1; day <= daysInMonth; day++) {
						                var listItem = $('<li>' + day + '</li>');
						                daysList.append(listItem);

						                // 오늘 날짜 표시하기
						                var today = new Date();
						                if (day === today.getDate() && month === today.getMonth() && year === today.getFullYear()) {
						                    listItem.addClass('active');
						                }

						                // 날짜 클릭 이벤트 처리
						                listItem.click(function() {
						                    var selectedDate = $(this).text();
						                    console.log('선택한 날짜:', selectedDate);

						                    // 선택한 날짜를 URL 파라미터로 추가하여 서버로 전송 (예시: selectDate?date=2024-07-12)
						                    var formattedDate = year + '-' + ('0' + (month + 1)).slice(-2) + '-' + ('0' + selectedDate).slice(-2);
						                    window.location.href = 'selectDate?date=' + formattedDate;
						                });
						            }
						        }
						    });
						</script>
							<div class="search">
						<h3 class="blind">search section</h3>
						<form action="keyword" method="get">
							<div class="search_input_box">
								<input type="search" name="keyword" id="insearch" maxlength="255" autocomplete="off" class="search_input" data-atcmp-element><!--
						--><button type="submit" class="btn_search">
									<span class="ico_btn_search">
										<svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="none"><path fill="#0447CC" fill-rule="evenodd" d="M8.26 4.63a3.63 3.63 0 1 1-7.26 0 3.63 3.63 0 0 1 7.26 0Zm-.73 3.608a4.63 4.63 0 1 1 .707-.707l3.03 3.028-.708.707-3.028-3.028Z" clip-rule="evenodd"/></svg>
										<span class="blind">search button</span>
									</span>
								</button>
							</div>
						</form>
						<div class="recent clearfix">
							<h4>최근검색어</h4>
							<ul class="clearfix">
								<li><a href="keyword?keyword=tws"><span>투어스</span></a></li>
								<li><a href="keyword?keyword=plave"><span>플레이브</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</aside>
			<div class="sec_wrap">
				<section class="popup">
					<h2>POPUP</h2>
					<div class="popup_wrap">
						<div class="view_mask">
							<ul class="clearfix">
								<c:forEach var="list" items="${artlist}">
								<li>
									<div class="img_wrap">
										<a href="/view?popCode=${list.popCode}"><img src="<c:url value='${list.rink}' />" alt="poster image"></a>
									</div>
									<p class="title">${list.popName}</p>
								</li>
								</c:forEach>
							</ul>
						</div>
						<button class="dir_btn prev _L _bg_BK"><span><span class="blind">prev button</span></span></button>
						<button class="dir_btn next _L _bg_BK"><span><span class="blind">next button</span></span></button>
					</div>
				</section>
				<section class="dummy">
					<h2 class="blind">dummy</h2>
				</section>
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
</body>
</html>