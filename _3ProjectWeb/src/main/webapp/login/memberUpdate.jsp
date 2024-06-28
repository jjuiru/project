<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 String memberId = (String)session.getAttribute("userId");
 if(memberId==null){
 	response.sendRedirect("../login/login_main.jsp");
 }
 
     request.setCharacterEncoding("utf-8");
 
     // 전달받은 값 읽기
     String id  = request.getParameter("id");
     String email   = request.getParameter("email");
     String name = request.getParameter("name");
 
     // 빈 칸이 하나라도 있으면 오류 출력하고 종료
     if ( email   == null || email.length()   == 0 ||
         name == null || name.length() == 0) {
 %>      
         <script>
             alert('모든 항목이 빈칸 없이 입력되어야 합니다.');
             history.back();
         </script>
 <%        
     }
 
     MemberDao dao = MemberDao.getInstance();
     Member board = new Member(id, email, name);
     dao.update(board);

 if("admin".equals((String)session.getAttribute("userId"))){ 
	response.sendRedirect("member_list.jsp"); 
}else{
response.sendRedirect("mypage.jsp"); 
}%>
    
