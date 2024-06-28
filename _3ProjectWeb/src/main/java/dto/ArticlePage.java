package dto;

import java.util.List;

public class ArticlePage {
	private int total;   //전체 게시글의 수 레코드수
	private int currentPage; //현재 페이지 나타나는 페이지 수 > pageNum 의 값
	private List<Board> content; //내용
	private int totalPages; //전체 페이지의 갯수
	private int startPage; //시작 페이지
	private int endPage; //끝나는 페이지
	
	//size: 한 페이지당 보여줄 목록의 개수
	public ArticlePage(int total, int currentPage, int size, List<Board> content ) {
		this.total=total;
		this.currentPage=currentPage;
		this.content=content;
		
		if(total == 0) { // 만약에 레코드가 없다면
			totalPages=0; //전체 페이지 갯수 0
			startPage=0; //시작 0
			endPage=0; //끝 0
			
		}else { //레코드 내용이 존재한다면
			totalPages = total/size; //전체 페이지는 전체 개시글의 수 나누기 한페이지에 보여줄 목록 갯수
			if(total % size >0) { //만약 나머지가 0보다 크면 
				this.totalPages++; //토탈 페이지가 넘어가기 때문에 +1을 해 준다
			}
			
			int modVal =currentPage % 5; //현재 페이지의 번호를 하단 목록 번호의 갯수 
			//현재 페이지가 1이라면 나머지 1 발생 , 2,3,4, 5일땐 0
			startPage= currentPage/5*5+1; //0*5+1 =1 전부 
			if(modVal==0) startPage -=5;
			
			//startPage,endPage: 화면 하단에 보여줄 페이지 이동 링크의 시작 번호와 끝 번호
			endPage= startPage +4;
			if(endPage >totalPages) endPage=totalPages;
		}
	}
	
	public boolean hasNoArticles() {
		return total == 0; // 게시글이 없으면 true
	}
	public boolean hasArticles() {
		return total > 0;// 게시글이 있다면 true
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Board> getContent() {
		return content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

}