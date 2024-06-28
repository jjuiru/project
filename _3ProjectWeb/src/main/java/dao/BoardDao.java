package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ArticlePage;
import dto.Board;

public class BoardDao { // 싱글턴 클래스
	private static Connection conn;
	private static BoardDao dao = new BoardDao();

	private BoardDao() {
	} // 생성제한

	public static BoardDao getInstance() {
		BoardDao.getConnection();
		return dao;
		// 오직 메소드를 통해서만 객체를 접근할 수 있다.
		// 페이지마다 접속할 수 없도록 만든다. 즉 웹페이지에 접근시 한번만 한 상태에서 서비스한다.
	}

	// DB에 접속하는 코드를 단 하나로만 사용가능하게 한다.
	private static void getConnection() {
//		Connection conn = null; 굳이 안써도 되는데 왜 쓸까???
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return conn; 리턴은 지역변수일 때 사용하는데, 전역변수 conn이 있으므로 리턴이 없어도 상관은 없다.
	}

	// Board list에 jsp에서 호출한 값의 정보를 저장하여 보관, 즉 회원정보를 가지고 있다. 회원정보가 필요한 곳은 list를 호출하여
	// 사용
	
	public int selectCount() {
		String sql="select count(*) from board";
		PreparedStatement pstmt;
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				int total= rs.getInt("total");
				return total;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArticlePage paging() {
		int total=selectCount();
		List<Board> list=selectList();						
		ArticlePage article = new ArticlePage(total, 2, 5, list);		
		return article;
		
	}
	// -----------------------------------
	public ArrayList<Board> selectList() {
		ArrayList<Board> list = new ArrayList<Board>();
		// List는 인터페이스 타입으로 다형성을 사용하기 위해서 사용
		String sql = "SELECT d.num, m.id, d.title, d.content, TO_CHAR(d.regtime, 'YYYY-MM-DD') as regtime, d.hits, d.memberno " +
                "FROM member m JOIN board d ON m.memberno = d.memberno";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board(rs.getInt("num"), rs.getString("id"), rs.getString("title"),
						rs.getString("content"), rs.getString("regtime"), rs.getInt("hits"), rs.getInt("memberno"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// -------------------------------------
	public Board selectOne(String id, int num, boolean inc) {
		Board board = null;
//		String sql = "select * from board where num=" + num;
		String sql = "select d.num, m.id, d.title, d.content , d.regtime, d.hits, d.memberno"
				+ " from member m, board d"
				+ " where m.memberno=d.memberno and m.id=? and d.num=?"; // Prepared전용
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // Prepared전용
			pstmt.setInt(2, num); // Prepared전용
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board(rs.getInt("num"), rs.getString("id"), rs.getString("title"),
						rs.getString("content"), rs.getString("regtime"), rs.getInt("hits"), rs.getInt("memberno"));
				
				if (inc) {
					pstmt = conn.prepareStatement("UPDATE board SET hits = hits + 1 where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	// ---------------------------------------
//	public void hitsUp(int num) {		
//		String sql = "UPDATE board SET hits = hits + 1 where num=" + num;
//		PreparedStatement pstmt;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			int rs = pstmt.executeUpdate();
//			// 업데이트 잘됐는지 확인하는 문장
//			if (rs > 0) {
//			    System.out.println("업데이트가 성공적으로 수행되었습니다.");
//			} else {
//			    System.out.println("업데이트에 실패했습니다.");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}
	// ------------------------------------------

	public int delete(int num) {
	    int result = 0;
	    String sql = "DELETE FROM board WHERE num=?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, num);
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	
	public Board selectId(String id) {
		Board board1 = null;
//		String sql = "select * from board where num=" + num;
		String sql = "select memberno from member where id=?"; // Prepared전용
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // Prepared전용
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				board1 = new Board(rs.getInt("memberno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board1;
	}
	
	
	public int insert(Board board, String id) {
		   int memberNo = selectId(id).getMemberno();
		    if (memberNo == 0) {
		        System.out.println("Member not found for id: " + id);
		        return 0; // 혹은 에러 처리
		    }
		    String sql = "INSERT INTO board (num, title, content, regtime, hits, memberno) VALUES (seq_board.nextval, ?,?, SYSDATE, 0, ?)";
		    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        pstmt.setString(1, board.getTitle());
		        pstmt.setString(2, board.getContent());
		        pstmt.setInt(3, memberNo);
		        return pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return 0;
		}

	public void update(Board board) {
		String sql = "UPDATE board SET title=?, content=?, regtime=SYSDATE WHERE num=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			// 쿼리 실행
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
