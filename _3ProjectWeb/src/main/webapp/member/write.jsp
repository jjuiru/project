<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%

// 로그인체크
String memberId = (String)session.getAttribute("userId");
if(memberId==null){
%>
<script>
window.onload = function() {
    alert('로그인을 해주세요');   
    location.href = "../login/login_main.jsp";
};
</script>
<%} %>

<%
    // 글 번호 값 얻기, 주어지지 않았으면 0으로 설정
    String id;
    String tmp = request.getParameter("num");  
//int num = Integer.parseInt(request.getParameter("num"));
//list에서 넘어올때는 링크만 넘어오기 때문에 num값이 넘어오지 않는다. 넘어오지 않는 값을 바꾸려면 오류가 발생
//하지만 view에서 넘어올 때는 num값이 넘어오기 때문에 이에 조건문을 붙인다.
//만약 아래 문장을 쓰고 싶지 않다면 list 에서 넘어오는 num값에 0을 주면 된다.
    int ck = (tmp != null && tmp.length() > 0) ? 1 : 0;

    // 새 글쓰기 모드를 가정하고 변수 초기값 설정
    int num;
    String title   = "";
    String content = "";
    String action  = "insert.jsp";
    //기본 action의 값은 insert 폼

    // 글 번호가 주어졌으면, 글 수정 모드
     if (ck > 0) {
    	id = request.getParameter("id");
    	num = Integer.parseInt(tmp);
    	BoardDao dao = BoardDao.getInstance();
    	Board board = dao.selectOne(id, num, false);
    	
    	// 글 데이터를 변수에 저장
    	num = board.getNum();
        id  = board.getId();
        title   = board.getTitle();
        content = board.getContent();

		// 글 수정 모드일 때는 저장 버튼을 누르면 UPDATE 실행
		action  = "update.jsp?num=" + num+"&id="+id;

    }
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>모하지갤러리</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link rel="icon" href="favicon.ico" type="image/x-icon">
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
				<li><a href="../minipage/help.jsp">Help</a></li>
				<li><a href="logout.jsp">Logout</a></li>
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
                <li><a href="../minipage/help.jsp">Help</a></li>
				<li><a href="login_main.jsp">Login</a></li>
				<li><a href="../minipage/join.jsp">join</a></li>
			</ul>		
		<!-- 메뉴의 상단영역 -->
		<%
    }
%>    </div>
	</header>
 <figure style="background-color: #FFFFFF; padding-top: 5px;">
    <div class="container" style="padding-top: 50px;">
<form method="post" id="writeForm" action="<%=action%>">

    <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">제목</label>
       <input type="text" class="form-control" name="title" maxlength="80" value="<%=title%>" id="exampleFormControlInput1" placeholder="제목 입력">
      </div>
      
      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">내용</label>
        <textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="10" placeholder="내용 입력" ><%=content%></textarea>
      </div>

    <br>
 <button type="button" id="submitButton" class="btn btn-dark">저장</button>
 <button type="button" class="btn btn-dark" onclick="history.back()">취소</button>
</form>
<script>
    // 서브밋 버튼을 클릭했을 때 실행될 함수를 정의합니다.
    document.getElementById("submitButton").addEventListener("click", function() {
        // JavaScript로 폼을 서브밋합니다.
        document.getElementById("writeForm").submit();
    });
</script>
 </div>
 
 

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
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
	</footer>
</body>
</html>
