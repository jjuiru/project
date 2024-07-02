package com.mohaji.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Artboard {

	private String popCode;
	private String popName;
	private String startDay;
	private String endDay;
	private String content;
	private String rink;
	private String weblink;
	private String place;
	private int starAvg;
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
	public String getRink() {
		return rink;
	}
	public void setRink(String rink) {
		this.rink = rink;
	}
	public String getWeblink() {
		return weblink;
	}
	public void setWeblink(String weblink) {
		this.weblink = weblink;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getStarAvg() {
		return starAvg;
	}
	public void setStarAvg(int starAvg) {
		this.starAvg = starAvg;
	}
}
