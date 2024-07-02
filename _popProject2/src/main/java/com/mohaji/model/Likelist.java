package com.mohaji.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Likelist {
	private Long likeCode;
    private String userId;
	private String popCode;
	private String popName;
	private String startDay;
	private String endDay;
	private String content;
	
	public Long getLikeCode() {
		return likeCode;
	}

	public void setLikeCode(Long likeCode) {
		this.likeCode = likeCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPopCode() {
		return popCode;
	}

	public void setPopCode(String popCode) {
		this.popCode = popCode;
	}

	public String getPopName() {
		return popName;
	}

	public void setPopName(String popName) {
		this.popName = popName;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Likelist() {};
	
	public Likelist(String userId, String popName, String startDay, String endDay) {
		super();
		this.userId = userId;
		this.popName = popName;
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public Likelist(String userId, String popCode) {
		super();
		this.userId = userId;
		this.popCode = popCode;
	}

	public Likelist(Long likeCode, String userId, String popCode, String popName, String startDay, String endDay,
			String content) {
		super();
		this.likeCode = likeCode;
		this.userId = userId;
		this.popCode = popCode;
		this.popName = popName;
		this.startDay = startDay;
		this.endDay = endDay;
		this.content = content;
	}
	
	
	
	
	

}

