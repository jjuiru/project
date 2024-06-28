package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findByLoginId(String loginId);
    Member findMemberByLoginId(String loginId);

    Member findByMemberId(int memberId);

    @Query("select m.name from Member m where m.memberId = :memberId")
    String findMemberNameByMemberId(@Param("memberId") Integer memberId);

    @Query("select m.name from Member m join Post p on m.memberId = p.memberId where m.memberId = :memberId")
    List<String> findMemberNamesByMemberId(@Param("memberId") Integer memberId);



}
