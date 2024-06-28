package com.mohaji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohaji.model.Member;
import com.mohaji.repository.MemberMapper;

@Service
public class LoginCheckService {

	@Autowired
	MemberMapper memberMapper;

	public boolean loginCheck(String userId, String pass) {
		System.out.println(userId);
		List<Member> members = memberMapper.selectAllMember();
		System.out.println(members);

		for (Member member : members) {
		        if (member.getUserId().equals(userId) && member.getPass().equals(pass)) {
		        	System.out.println("true");
		            return true; // 사용자 ID와 비밀번호가 일치하는 회원이 있을 경우 true 반환
		        }
		    }
		System.out.println("일치하는 회원이 없습니다.");		
		return false; 
 }
}
