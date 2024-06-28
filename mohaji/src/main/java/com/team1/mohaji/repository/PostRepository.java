package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAll();

    Post findByPostId(int postId);

    @Modifying
    @Query("UPDATE Post SET views = views + 1 WHERE postId = :postId")
    void updateViews(@Param("postId") Integer postId);

    public int deleteByPostId(Integer postId);

    List<Post> findByBoardIdOrderByCreatedAtDesc(int boardId);

    @Query("SELECT p FROM Post p WHERE p.board.boardId = :boardId")
    Page<Post> findByBoardId(@Param("boardId") int boardId, Pageable pageable);

    List<Post> findByTitleContainingAndBoardBoardId(String title, int boardId);


}