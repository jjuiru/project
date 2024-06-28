package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int boardId;
    private int groupId;
    @Column(name = "course_id", nullable = true)
    private Integer courseId;
    @Column(name = "board_name", nullable = false)
    private String boardName;
    @OneToMany(mappedBy = "board")
    private List<Post> posts;

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", name='" + boardName + '\'' +
                ", posts=" + posts +
                '}';
    }


}
