package com.mohaji;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MemberDto {
	private Long memberno; //id는 직접 보여지지 않는 고유 식별 필드
	private String email; // 로그인에 사용되는 id
	private String password; // pass
	private String nickname; // 가입시 필요한 이름
	private String name;
	private int phonnumber;
	private LocalDateTime registerDateTime; //현재시각
	
	// lombok을 이용해 getter setter와 생성자를 자동생성했다. 
	
	// 이전 비밀번호와 바꿀 비밀번호를 입력받고 예전 비범이 저장된 비번과 같다면 새로운 비번으로 바꿔준다. (인증후 바꿔주기)
	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword)) throw new WrongIdPasswordException();
	//이때 패스워드가 아이디와 다르면 아이디 패스워드가 다르다고 알려주는 에러처리를 출력한다. 
			this.password=newPassword;
	}	
}

