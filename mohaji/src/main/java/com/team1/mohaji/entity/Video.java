package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private int videoId;

    @NotBlank
    @Column(name = "video_ycode", nullable = false, length = 150)
    private String videoYcode;
    @NotBlank
    @Column(name = "video_title", nullable = false, length = 90)
    private String videoTitle;

    @Column(name = "video_desc", length = 300)
    private String videoContent;
    @NotBlank
    @Column(name = "video_length", nullable = false)
    private int videoLength;

    // Getters and setters
}
