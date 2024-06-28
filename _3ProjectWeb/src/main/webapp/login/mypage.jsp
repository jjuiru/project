<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%//로그인체크
    String memberId = (String)session.getAttribute("userId");
        if(memberId==null){
        	%>
        	    <script>
        	        window.onload = function() {
        	            alert('잘못된 접근입니다. 로그인이 필요합니다.');
        	            location.href = "../login/login_main.jsp";
        	        };
        	    </script>
        	<%
        	    return; // 리디렉션 후에는 더 이상 코드 실행하지 않음
        	}
 MemberDao dao = MemberDao.getInstance();
 Member member = dao.select(memberId); // selectList() 호출해보기
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
				<li><a href="../login/mypage.jsp">Mypage</a></li>
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
<figure style="max-width: 100%; background-color: #fff;display: flex; padding-top: 50px; flex-direction: column; align-items: center; margin-top: 5vw auto;">
    <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Account</button>
            <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">MyBoard</button>
            <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">Like</button>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
            <div><h1>account</h1></div>
            <br>
            <form id="myForm" method="post">
                <div class="mb-3">
                    <label for="id" class="form-label">아이디</label> <input
                        type="text" class="form-control" id="id" name="id" readonly
                        value="<%=member.getId()%>">
                </div>
                <div class="mb-3">
                    <label for="emai" class="form-label">이메일</label> <input
                        type="email" class="form-control" id="email" name="email"
                        value="<%=member.getEmail()%>">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">이름</label> <input
                        type="text" class="form-control" id="name" name="name"
                        value="<%=member.getName()%>">
                </div>
                <button type="submit" class="btn btn-sm btn-outline-secondary"
                        onclick="setAction('memberUpdate.jsp')">수정</button>
                <button type="button" class="btn btn-sm btn-outline-secondary" 
                        onclick="confirmDelete(<%=member.getMemberno()%>)">회원탈퇴</button>

                <div class="mb-3" style="display: none;">
                    <label for="memberno" class="form-label">번호</label> <input
                        type="text" class="form-control" id="memberno" name="memberno" readonly
                        value="<%=member.getMemberno()%>">
            </form>
            <script>
                function setAction(action) {
                    document.getElementById("myForm").action = action;
                }
                function confirmDelete(memberno) {
                    var confirmDelete = confirm("계정 삭제시 모든 게시글이 지워집니다. 정말로 삭제하시겠습니까?");
                    if (confirmDelete) {
                        var formData = new FormData(document.getElementById("myForm"));
                        // URL 쿼리 문자열 생성
                        var queryString = new URLSearchParams(formData).toString();
                        // memberDelete.jsp로 이동하면서 데이터 전송
                        location.href = "memberDelete.jsp?" + queryString;
                    } else {

                    }
                }
            </script>
        </div>
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
<script>
    function goToSearchAcc() {
        window.location.href = "searchAcc.jsp";
    }
</script>
        </div>
        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab" tabindex="0">
            <div><h1>Like</h1></div>
            <p>This is the content of Like tab.</p>
        </div>
    </div>
</figure>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script> 	
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