package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Attached extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachedId;
    @Column(name = "member_id", nullable = false)
    private Integer memberId;
//    @ManyToOne
//    @JoinColumn(name = "member_id", nullable = false)
//    private Member member;
    private String storagePath;
    private String originalName;
    private String savedName;
    private String attachedType;
    private Long attachedSize;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Override
    public String toString() {
        return "Attached{" +
                "attachedId=" + attachedId +
                ", memberId=" + memberId +
                ", storagePath='" + storagePath + '\'' +
                ", originalName='" + originalName + '\'' +
                ", savedName='" + savedName + '\'' +
                ", attachedType='" + attachedType + '\'' +
                ", attachedSize=" + attachedSize +
                ", post=" + post.getPostId() +
                '}';
    }
}
