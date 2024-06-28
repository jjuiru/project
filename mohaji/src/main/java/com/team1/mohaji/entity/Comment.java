package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Comment {
    @Id
    private Integer commentId;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    private String content;
    private Integer likeId;
//    @ManyToOne
//    @JoinColumn(name = "like_id")
//    private Like like;
    private Timestamp comCreatedAt;
    private Timestamp comUpdatedAt;
    private String comAuthorId;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;


}
