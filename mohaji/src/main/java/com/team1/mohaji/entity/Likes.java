package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private int likeId;

    private Integer postId;
    private Integer commentId;
    private Integer memberId;
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;
//    @ManyToOne
//    @JoinColumn(name = "comment_id")
//    private Comment comment;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

}
