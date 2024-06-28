<%@page import="dao.MemberDao"%>
<%@page import="uill.Cookies"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
//로그인체크
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
   request.setCharacterEncoding("utf-8");
   String id= request.getParameter("id");
   String email= request.getParameter("email");
   Member member =MemberDao.getInstance().selectForLogin(id, email);
   
// Cookies cookies = new Cookies(request);여기서는 꼭 객체정보를 사용하지 않아도 Cookies를 사용할 수 있다.
//static 메소드 사용 but 쿠키 정보를 가져오기 위해서는 사용해야한다.
String check = request.getParameter("check");
if (check != null && check.equals("on")) {
	//체크 파일이 체크가 되면 값이 remember값이 on으로 넘어온다. 
	// 이메일을 작성하지 않았거나, 체크박스에 체크를 하지 않았다면 쿠키를 지우고 둘다 참이라면 쿠키를 생성해서 저장한다.
	response.addCookie(Cookies.createCookie("id", id, "/", 60 * 60));
	response.addCookie(Cookies.createCookie("email", email, "/", 60 * 60));
	// 쿠키글 저장(쿠키를 생성 (1시간 쿠키가 살아있을 수 있도록 설정 ));
} else {
	response.addCookie(Cookies.createCookie("id", "", "/", 0));
	response.addCookie(Cookies.createCookie("email", "", "/", 0));
}
      
           // 그런 레코드가 있으면, 세션 속성을 등록하고, 메인 화면으로 돌아감
           if (member !=null) {
               session.setAttribute("userId",   member.getId());
               session.setAttribute("userName", member.getName());
   //            session.setAttribute("member", member);//객체 저장도 가능
                   
               response.sendRedirect("../mainPage.jsp");  
   ///login_main.jsp
               return;
           }
   %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>
