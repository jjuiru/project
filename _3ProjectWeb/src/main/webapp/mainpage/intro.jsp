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
				<li><a href="../mainpage/intro.jsp">INTRO</a></li>
				<li><a href="../mainpage/gallery.jsp">GALLERY</a></li>
				<li><a href="../mainpage/youtube.jsp">YOUTUBE</a></li>
				<li><a href="../member/list.jsp">COMMUNITY</a></li>
				<li><a href="../mainpage/location.jsp">LOCATION</a></li>
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
				<li><a href="../login/mypage.jsp">Mypage</a></li>
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
<figure style="max-width: 800px; background-color: rgba(0, 0, 0, 0.9); color: #ddd; display: flex; padding: 50px; flex-direction: column; align-items: flex-start; margin: 5vw auto; text-align: left; border-radius: 5px; border: none;">
    <div style="font-size: 18px; line-height: 1.6;">
        <p style="margin-bottom: 20px;">이 웹 페이지는 크게 세 가지 기능을 지원합니다.</p>
        <p>정보 확인(갤러리, 게시판)</p>
        <p>관리자 기능(계정관리)</p>
        <p>일반 회원의 로그인과 활동 저장</p>
        <br>
        <p><strong>일반 회원의 경우</strong></p>
        <ul style="list-style-type: none; padding-left: 0; margin-bottom: 20px;">
            <li>정보 확인에서 회원은 갤러리에서 사진을 구경 할 수 있습니다.</li>
            <li>게시판에 글을 작성해 다른 회원과 소통 할 수 있습니다.</li>
            <li>본인이 작성한 글은 언제든지 삭제 혹은 수정이 가능합니다.</li>
            <li>mypage에서 본인의 계정정보를 수정, 혹은 회원탈퇴를 진행 할 수 있습니다.</li>
        </ul>
        <p><strong>관리자의 경우</strong></p>
        <ul style="list-style-type: none; padding-left: 0; margin-bottom: 20px;">
            <li>일반 회원의 모두 확인 할 수 있으며 삭제, 추가 또한 가능합니다.</li>
        </ul>
        <p>갤러리는 모든 방문자가 확인 할 수 있고, 게시판은 로그인 회원만 사용이 가능합니다.</p>
    </div>
</figure>
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