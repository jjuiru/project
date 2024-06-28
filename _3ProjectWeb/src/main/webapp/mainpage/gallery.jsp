<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>모하지갤러리</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c47106c6a7.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../css/style.css">
<script defer src="js/ie.js"></script>
</head>
<body>
	<header>
		<div class="inner">
			<!-- 메인화면을 나타내주는 가장 큰 메뉴 -->
			<h1>
				<a href="../mainPage.jsp">MOHAJIGALLERY</a>
			</h1>
			<ul id="gnb">
				<!-- gnb 메뉴바 >기능이 있는 작은 메뉴들 -->
				<li><a href="intro.jsp">INTRO</a></li>
				<li><a href="gallery.jsp">GALLERY</a></li>
				<li><a href="youtube.jsp">YOUTUBE</a></li>
				<li><a href="../member/list.jsp">COMMUNITY</a></li>
				<li><a href="location.jsp">LOCATION</a></li>
			</ul>
			<ul class="util">
<%
    if ((String)session.getAttribute("userId") != null)
    	// Member member = (Member)session.getAttribute("member");
    	//if (member.getId() != null) 
    	{          
        // 로그인 상태일 때의 출력 
%>			
<li><a href="mypage.jsp"><%=(String) session.getAttribute("userName")%>님 로그인</a></li>
				<li><a href="../login/help.jsp">Help</a></li>
				<li><a href="../login/logout.jsp">Logout</a></li>
				<%if("admin".equals((String)session.getAttribute("userId"))){ %>
					<li><a href="../login/member_list.jsp">admin page</a></li>		
				
				<% } else{%>			
				<li><a href="mypage.jsp">Mypage</a></li>
				<%}%>
			</ul>
<%  
    } else {                       
        // 로그인되지 않은 상태일 때의 출력           				
%>
                <li><a href="../login/help.jsp">Help</a></li>
				<li><a href="../login/login_main.jsp">Login</a></li>
				<li><a href="../login/member_join_form.jsp">join</a></li>
			</ul>		
		<!-- 메뉴의 상단영역 -->
		<%
    }
%>    </div>
	</header>
<figure id="image-container" style="max-width: 100%; background-color: #fff; display: flex; padding-top: 50px; justify-content: center; align-items: center; margin-top: 5vw auto; flex-wrap: wrap; gap: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_01.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_02.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_03.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_04.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_05.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_06.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_07.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
    <img src="../img/KakaoTalk_20240304_015245193_08.jpg" class="img-thumbnail" alt="..." style="width: 200px; height: auto; margin-bottom: 20px;">
</figure>

<!-- 모달 팝업 -->
<div id="myModal" class="modal">
  <span class="close">&times;</span>
  <img class="modal-content" id="img01">
</div>

<script>
    // 이미지 요소들을 가져옴
    const images = document.querySelectorAll('.img-thumbnail');

    // 각 이미지에 이벤트 추가
    images.forEach(image => {
        // 마우스를 가져다 대었을 때
        image.addEventListener('mouseover', function() {
            this.style.transform = 'scale(1.2)'; // 이미지 크기를 확대
        });

        // 마우스가 벗어났을 때
        image.addEventListener('mouseout', function() {
            this.style.transform = 'scale(1)'; // 이미지 크기를 원래 크기로
        });

        // 이미지 클릭 시
        image.addEventListener('click', function() {
            // 모달 팝업 보여주기
            const modal = document.getElementById('myModal');
            const modalImg = document.getElementById('img01');
            modal.style.display = 'block';
            modalImg.src = this.src;

            // 이미지를 윈도우의 1/3 크기로 설정
            modalImg.style.width = '500px';
            modalImg.style.height = '700px';

            // 모달을 화면 중앙으로 이동
            modal.style.top = '50%';
            modal.style.left = '50%';
            modal.style.transform = 'translate(-50%, -50%)';
        });
    });

    // 모달 닫기 버튼
    const closeBtn = document.querySelector('.close');
    closeBtn.addEventListener('click', function() {
        const modal = document.getElementById('myModal');
        modal.style.display = 'none';
    });
</script>
	<footer>
		<div class="inner">
			<div class="upper">
				<h1>DCODELAB</h1>
				<ul>
					<li><a href="#">Plicy</a></li>
					<li><a href="#">Terms</a></li>
					<li><a href="#">Family Site</a></li>
					<li><a href="#">Sitemap</a></li>
				</ul>
			</div>

			<div class="lower">
				<address>
					Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestias,
					voluptatem? <br> TEL: 010-7760-3956
				</address>
				<p>2020 DCODELAB uuuuummmmm</p>
			</div>
		</div>
		<!-- 기업정보 -->
	</main>
	</footer>

</body>
</html>