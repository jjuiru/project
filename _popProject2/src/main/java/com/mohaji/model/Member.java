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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getCreateDay() {
		return createDay;
	}
	public void setCreateDay(String createDay) {
		this.createDay = createDay;
	}
	public String getUpdateDay() {
		return updateDay;
	}
	public void setUpdateDay(String updateDay) {
		this.updateDay = updateDay;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUevent() {
		return uevent;
	}
	public void setUevent(String uevent) {
		this.uevent = uevent;
	}
	
}
