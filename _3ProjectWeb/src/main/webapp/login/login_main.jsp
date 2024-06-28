
<%@page import="uill.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 Cookies cookies = new Cookies(request);
//static 메소드 사용 but 쿠키 정보를 가져오기 위해서는 사용해야한다.
%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="../assets/js/color-modes.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.115.4">
<title>Signin Template · Bootstrap v5.3</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../css/sign-in.css" rel="stylesheet">
</head>
<body>
<div style="margin-top: 200px;">
	<main class="form-signin w-100 m-auto">
		<%
		if ((String) session.getAttribute("userId") != null)
		// Member member = (Member)session.getAttribute("member");
		//if (member.getId() != null) 
		{
			// 로그인 상태일 때의 출력
		%>
		<form action="logout.jsp" method="post">
			<%=(String) session.getAttribute("userName")%>님 로그인 
			<input style="margin-bottom: 10px;" type="submit" value="로그아웃"> 
			<input style="margin-bottom: 10px;" type="button" value="회원정보 수정" onclick="location.href='member_update_form.jsp';">
		</form>
		<%
		} else {
		// 로그인되지 않은 상태일 때의 출력
		%>
		<form action="login.jsp" method="post">
			<h1 class="h3 mb-3 fw-normal">로그인</h1>

			<%
			if (cookies.exists("email")) {
			%>

			<div class="form-floating">
				<input style="margin-bottom: 10px; border-radius: 10px;" type="text" class="form-control" id="id" name="id"
					placeholder="id" value="<%=cookies.getValue("id")%>"> 
					<label for="id">아이디</label>
			</div>

			<div class="form-floating">
				<input style=" border-radius: 10px;" type="email" class="form-control" id="email" name="email"
					value="<%=cookies.getValue("email")%>" placeholder="email">
				<label for="email">이메일</label>
			</div>
			<%
			} else {
			%>
			<div class="form-floating">
				<input style="margin-bottom: 10px; border-radius: 10px;" type="text" class="form-control" id="id" name="id" placeholder="id"> 
				<label for="id">아이디</label>
			</div>

			<div class="form-floating">
				<input style=" border-radius: 10px;" type="email" class="form-control" id="email" name="email"
					placeholder="email">
				<label for="email">이메일</label>
			</div>

			<%
			}
			%>

			<div class="form-check text-start my-3">
				<input class="form-check-input" type="checkbox"
					id="check" name="check" checked> <label class="form-check-label"
					for="check"> 아이디를 저장합니다. </label>
			</div>
			<div>
			<button style="margin-bottom: 10px; border-radius: 10px;" class="btn btn-sm btn-outline-secondary w-100 py-2" type="submit"
				onclick="location.href='login.jsp';">Sign in</button>
				</div>
		</form>
			<div>
			<button style= "margin-bottom: 10px; border-radius: 10px;" class="btn btn-sm btn-outline-secondary w-100 py-2"
				onclick="location.href='member_join_form.jsp';">join</button>
				</div>
				
			<div>
			<button style= "border-radius: 10px;" class="btn btn-sm btn-outline-secondary w-100 py-2"
				onclick="location.href='../mainPage.jsp';">main</button>
				</div>
			<p class="mt-5 mb-3 text-body-secondary">&copy; 2024–2027</p>
			<%
			}
			%>
	</main>
</div>

	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>