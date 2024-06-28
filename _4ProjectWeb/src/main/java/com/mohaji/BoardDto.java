package com.mohaji;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BoardDto {
	private Long memberno; //id는 직접 보여지지 않는 고유 식별 필드
	private String title; // 로그인에 사용되는 id
	private String content; // pass
	private String nickname; // 가입시 필요한 이름
	private String imgUrl;
	private int num;
	private LocalDateTime registerDateTime; //현재시각
}
