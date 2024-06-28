package com.team1.mohaji.dto;

import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.entity.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class PostDto {
    private Integer boardId;
    private String boardName;
    private Integer postId;
    private Integer sequenceNumber;
    private Integer lectureId;
    private String title;
    private String content;
    private Integer views;
    private Integer attachedId;
    private Integer likeId;
    private Integer memberId;
    private String memberName;
    private String updatedName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Attached> attachments;

    public PostDto(Post post, String memberName) {
        this.boardId = post.getBoard().getBoardId();
        this.boardName = post.getBoard().getBoardName();
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.views = post.getViews();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.memberId = post.getMemberId();
        this.memberName = memberName;
    }

}

