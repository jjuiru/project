package com.team1.mohaji.service;

import com.team1.mohaji.entity.Member;
import com.team1.mohaji.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Integer findUserIdByUsername(String username) {
        Member member = memberRepository.findMemberByLoginId(username);
        if (member != null) {
            return member.getMemberId();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
