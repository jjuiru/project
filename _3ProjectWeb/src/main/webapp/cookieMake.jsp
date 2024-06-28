<%@page import="uill.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String check = request.getParameter("popcheck");
if (check != null && check.equals("on")) {
	//체크 파일이 체크가 되면 값이 remember값이 on으로 넘어온다. 
	// 이메일을 작성하지 않았거나, 체크박스에 체크를 하지 않았다면 쿠키를 지우고 둘다 참이라면 쿠키를 생성해서 저장한다.
	response.addCookie(Cookies.createCookie("popcheck", "on", "/", 60));
	// 쿠키글 저장(쿠키를 생성 (1시간 쿠키가 살아있을 수 있도록 설정 ));
} else {
	response.addCookie(Cookies.createCookie("prpcheck", "", "/", 0));
	
} response.sendRedirect("mainPage.jsp?no=no"); 
 %>