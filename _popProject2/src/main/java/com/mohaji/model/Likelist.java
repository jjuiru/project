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

