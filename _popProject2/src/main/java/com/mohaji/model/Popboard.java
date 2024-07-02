package com.mohaji.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Popboard {

		private Long num;
	    private String userId;
		private String popCode;
		private String title;
		private String content;
		private int star;
		private String regtime;
		public Long getNum() {
			return num;
		}
		public void setNum(Long num) {
			this.num = num;
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public int getStar() {
			return star;
		}
		public void setStar(int star) {
			this.star = star;
		}
		public String getRegtime() {
			return regtime;
		}
		public void setRegtime(String regtime) {
			this.regtime = regtime;
		}

}
