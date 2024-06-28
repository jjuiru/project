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
				<li><a href="../minipage/help.jsp">Help</a></li>
				<li><a href="logout.jsp">Logout</a></li>
				<%if("admin".equals((String)session.getAttribute("userId"))){ %>
					<li><a href="member_list.jsp">admin page</a></li>		
				
				<% } else{%>			
				<li><a href="mypage.jsp">Mypage</a></li>
				<%}%>
			</ul>
<%  
    } else {                       
        // 로그인되지 않은 상태일 때의 출력           				
%>
                <li><a href="../minipage/help.jsp">Help</a></li>
				<li><a href="login_main.jsp">Login</a></li>
				<li><a href="member_join_form.jsp">join</a></li>
			</ul>		
		<!-- 메뉴의 상단영역 -->
		<%
    }
%>    </div>
	</header>
	<figure style="max-width: 100%; background-color: #fff;display: flex; padding-top: 50px; flex-direction: column; align-items: center; margin-top: 5vw auto;">	
		<form action="member_join.jsp" method="post">	
		<div><h1>join</h1></div>
			<br>
		<div class="mb-3" style=>
          <label for="exampleFormControlInput1" class="form-label">아이디</label>
          <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="id" name="id">
       </div>
       
       		<div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label">이메일</label>
          <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="email" name="email">
       </div>
       
       		<div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label">이름</label>
          <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="name" name="name">
       </div>
       <div>
			<button style= "border-radius: 10px;" class="btn btn-sm btn-outline-secondary"
				onclick="location.href='member_join_form.jsp';">입력</button>
				</div>
		</form>
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
