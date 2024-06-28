
<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
 request.setCharacterEncoding("utf-8");
 String id = request.getParameter("id");
 String email = request.getParameter("email");
 String name = request.getParameter("name");
 
 Member member =MemberDao.getInstance().select(id);
 
     if (member !=null ) {   
         // 이미 있는 아이디이면 오류 표시
%>
         <script>
             alert('이미 등록된 아이디입니다.');
             history.back()
         </script>
<%
       
     } else {       
     	Member member1 = new Member(id,email,name);
         MemberDao.getInstance().insert(member1);
     // 새로운 회원정보를 DB에 추가하는 쿼리
%>
         <script>
             alert('등록되었습니다.');
        	    location.href = "member_list.jsp";
             window.close();
             
         </script>
<%          
     }
%>


 
 response.sendRedirect("member_list.jsp");
 %>   
    
