<%@page import="dto.Member"%>
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>  
<%@ page import="java.time.*" %>
 
<%


String memberId = (String)session.getAttribute("userId");
if(memberId==null){
	response.sendRedirect("../login/login_main.jsp");
}

    request.setCharacterEncoding("utf-8");

    // 양식에 입력되었던 값 읽기
    String id  = memberId;
    String title   = request.getParameter("title"  );
    String content = request.getParameter("content");

    // 빈 칸이 하나라도 있으면 오류 출력하고 종료
    if (title   == null || title.length()   == 0 ||
        content == null || content.length() == 0) {
%>      
        <script>
            alert('모든 항목이 빈칸 없이 입력되어야 합니다.');
            history.back();
        </script>
<%        
        return;
    }

    BoardDao dao = BoardDao.getInstance();

    Board board = new Board(title, content);
    // 1번 Board board = new Board(0,writer, title, content, "",0);
    // num오토, date
    // 2번 Board board= new Board(); 기본 생성자만 있을 경우
    // board.setTitle(title); getter, setter를 통해 사용
    // board.setTitle(writer);
    // board.setTitle(content);
    dao.insert(board, id);
    
    // 목록보기 화면으로 돌아감
    response.sendRedirect("list.jsp");
%>     