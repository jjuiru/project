package com.mohaji.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter   
@AllArgsConstructor
@ToString     
public class Member {
	private String userId;
	private String pass;
	private String email;
	private String uname;
	private String createDay;
	private String updateDay;
	private String phoneNum;
	private String birth;
	private String gender;
	private String uevent;
	
}
