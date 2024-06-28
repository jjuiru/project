<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%  
 String memberId = (String)session.getAttribute("userId");
 boolean login = memberId == null ? false : true;
 MemberDao dao = MemberDao.getInstance();
 List<Member> list = dao.selectList(); // selectList() 호출해보기
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>모하지갤러리</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<script src="https://kit.fontawesome.com/c47106c6a7.js"
crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
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
				<li><a href="help.jsp">Help</a></li>
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
                <li><a href="help.jsp">Help</a></li>
				<li><a href="login_main.jsp">Login</a></li>
				<li><a href="member_join_form.jsp">join</a></li>
			</ul>		
		<!-- 메뉴의 상단영역 -->
		<%
    }
%>    </div>

	</header>	
	<% if (login) {          // 로그인 상태일 때의 출력 %>

	<figure style="background-color: #fff; padding-top: 5px;">
    <div class="container" style="padding-top: 5px">
        <h1>account</h1>
    <table class="table table-bordered table-hover">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">id</th>
      <th scope="col">email</th>
      <th scope="col">이름</th>
    </tr>
  </thead>
  
  <tbody class="table-group-divider">
  <%   for(Member member: list) {   %> 
<tr onclick="submitForm('<%= member.getMemberno() %>');" style="cursor: pointer;">
  <th scope="row"><%= member.getMemberno() %></th>
  <td><%= member.getId() %></td>
  <td><%= member.getEmail() %></td>
  <td><%= member.getName() %></td>

</tr>
              <% }%>
  </tbody>
<form id="memberForm" action="memberview.jsp" method="post">
  <input type="hidden" name="memberno" id="memberNoInput">
</form>

<script>
  function submitForm(memberno) {
    document.getElementById('memberNoInput').value = memberno;
    document.getElementById('memberForm').submit();
  }
</script>

</table>
<button type="button" class="btn btn-sm btn-outline-secondary" onclick="location.href='memberForm.jsp';">회원입력</button>
</div>
<% } else{%>
<script>
alert('접근 권한이 없습니다. 로그인 해주세요!');
	 location.href = "../login/login_main.jsp";
	 </script>
<% }%>
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