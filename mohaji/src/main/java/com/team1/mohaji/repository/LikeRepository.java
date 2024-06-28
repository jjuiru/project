package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

    boolean existsByPostIdAndMemberId(int postId, int memberId);

    @Transactional
    void deleteByPostIdAndMemberId(int postId, int memberId);

    boolean existsByCommentIdAndMemberId(int commentId, int memberId);

    @Transactional
    void deleteByCommentIdAndMemberId(int commentId, int memberId);


}