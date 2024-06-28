package dto;

public class Member {
 private int memberno;
 private String id;
 private String email;
 private String name;
 
 public Member(int memberno,String id, String email, String name) {
		super();
		this.memberno= memberno;
		this.id = id;
		this.email = email;
		this.name = name;
	}
 
public Member(String id, String email, String name) {
	super();
	this.id = id;
	this.email = email;
	this.name = name;
}

public Member(String id, String email) {
	super();
	this.id = id;
	this.email = email;
}
public String getId() {
	return id;
}
public String getEmail() {
	return email;
}
public String getName() {
	return name;
}
public void setId(String id) {
	this.id = id;
}
public void setEmail(String email) {
	this.email = email;
}
public void setName(String name) {
	this.name = name;
}

public int getMemberno() {
	return memberno;
}

@Override
public String toString() {
	return "MemberDao [id=" + id + ", email=" + email + ", name=" + name + "]";
}
 
 
}


