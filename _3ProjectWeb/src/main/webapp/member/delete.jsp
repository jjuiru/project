<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>  
    
<%
int num = Integer.parseInt(request.getParameter("num"));
// num을 int 타입으로 받기 때문에 변환해서 int에 저장한다.
String memberId = (String)session.getAttribute("userId");
if(memberId==null){
	response.sendRedirect("../login/login_main.jsp");
}
BoardDao dao = BoardDao.getInstance();
dao.delete(num);
%>
         <script>
             alert('삭제가 완료되었습니다.');
             location.href="list.jsp";
         </script>
<%
      // 변환된 num값을 delete로 전달.
//    response.sendRedirect("list.jsp");
//스크립트와 자바 코드를 함께 사용할 수없다.(같은 시간대에)
%>
