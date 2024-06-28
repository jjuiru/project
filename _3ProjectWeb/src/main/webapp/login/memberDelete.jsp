
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
 <%
String memberId = (String)session.getAttribute("userId"); 
 int memberno = Integer.parseInt(request.getParameter("memberno"));
 String id = request.getParameter("id");
if(memberId==null){
	response.sendRedirect("../login/login_main.jsp");
}
MemberDao dao = MemberDao.getInstance();
dao.delete(id,memberno);
%>
         <script>
             alert('삭제가 완료되었습니다.');
             location.href="member.view.jsp";
         </script>   
 <%   
 if("admin".equals((String)session.getAttribute("userId"))){ 
	response.sendRedirect("member_list.jsp"); 
}else{ 
session.removeAttribute("userId");
session.removeAttribute("userName");



response.sendRedirect("../mainPage.jsp"); 
}%>