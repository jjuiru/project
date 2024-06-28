package dto;

public class Board {
	// 컬럼명을 필드이름과 같게한다.
private int num;
private String title;
private String id;
private String content;
private String regtime;
private int hits;
private int memberno;

// 모든 필드를 저장하는 생성자와 get,setter를 만든다.
public Board(int num, String id, String title, String content, String regtime, int hits, int memberno) {
	this.num = num;
	this.id = id;
	this.title = title;
	this.content = content;
	this.regtime = regtime;
	this.hits = hits;
	this.memberno= memberno;
}

public Board(int memberno) {
	this.memberno = memberno;
}

public Board(int num, String title, String content) {
	this.num = num;
	this.title = title;
	this.content = content;
}

public Board(String id, String title, String content) {
	this(0,id, title, content, "",0,0); //생성자 호출
//	this.writer = writer;
//	this.title = title;
//	this.content = content;
}

public Board(String title, String content) {
	this(0,null, title, content, "",0,0); //생성자 호출
//	this.writer = writer;
//	this.title = title;
//	this.content = content;
}

public Board(int num, String id, String title, String content) {
	this(num ,id, title, content, "",0,0); //생성자 호출
}

public int getNum() {
	return num;
}
public String getId() {
	return id;
}
public String getTitle() {
	return title;
}
public String getContent() {
	return content;
}
public String getRegtime() {
	return regtime;
}
public int getHits() {
	return hits;
}
public void setNum(int num) {
	this.num = num;
}
public void setId(String writer) {
	this.id = writer;
}
public void setTitle(String title) {
	this.title = title;
}
public void setContent(String content) {
	this.content = content;
}
public void setRegtime(String regtime) {
	this.regtime = regtime;
}
public void setHits(int hits) {
	this.hits = hits;
}

public int getMemberno() {
	return memberno;
}

public void setMemberno(int memberno) {
	this.memberno = memberno;
}

//테스트용  tostring
@Override
public String toString() {
	return "Board [num=" + num + ", id=" + id + ", title=" + title + ", content=" + content + ", regtime="
			+ regtime + ", hits=" + hits + "]";
}


}
