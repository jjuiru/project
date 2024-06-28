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
 <%  // 지정된 글 번호 얻기
 
    int num = Integer.parseInt(request.getParameter("num"));
    String id = request.getParameter("id");
    BoardDao dao = BoardDao.getInstance();
    Board board = dao.selectOne(id, num, true);


    // 게시글 데이터를 담을 변수 정의          
    // 글 데이터를 변수에 저장
           num= board.getNum();
           id  = board.getId();
           String title   = board.getTitle();
           String content = board.getContent();
           String regtime = board.getRegtime();
           int hits    = board.getHits();
    
            // 글 제목과 내용이 웹 페이지에 올바르게 출력되도록 
            // 공백과 줄 바꿈 처리
            title   = title.replace  (" ", "&nbsp;");
            content = content.replace(" ", "&nbsp;").replace("\n", "<br>");
            
            // 이 글의 조회수를 1 올림 update를 해야한다. 
//            dao.hitsUp(num);
//            pstmt.executeUpdate(
//                   "update board set hits=hits+1 where num=" + num);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<li><a href="../minipage/mypage.jsp"><%=(String) session.getAttribute("userName")%>님 로그인</a></li>
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
 <div class="container" style="padding-top: 5px;">
   <br>
 <div><h4 style="font-weight: 800;">Community</h4></div>
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
    <tr>
      <th scope="row">제목</th>
      <td><%=title%></td>
    </tr>
    <tr>
      <th scope="row">작성자</th>
      <td><%=id%></td>
    </tr>
    <tr>
      <th scope="row">작성일시</th>
      <td><%=regtime%></td>
    </tr>
        <tr>
      <th scope="row">조회수</th>
      <td><%=hits%></td>
    </tr>
       <tr>
      <th scope="row">내용</th>
      <td><%=content%></td>
    </tr>
  </tbody>
</table>

<% if(id.equals(memberId)){%>

<input type="button" value="목록보기" class="btn btn-sm btn-outline-secondary" onclick="location.href='list.jsp'">
<input type="button" class="btn btn-sm btn-outline-secondary" value="수정"
       onclick="location.href='write.jsp?id=<%=id%>&num=<%=num%>'">
<input type="button" class="btn btn-sm btn-outline-secondary" value="삭제"
       onclick="location.href='delete.jsp?num=<%=num%>'">
   <%  }else{  %>
   <input type="button" value="목록보기" class="btn btn-sm btn-outline-secondary" onclick="location.href='list.jsp'">
   <%  }%>
  </div> 
<br>

<!--get방식으로 값 전달한다.  -->
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
