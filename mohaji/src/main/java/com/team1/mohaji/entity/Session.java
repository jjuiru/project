package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "session")
public class Session {

    @OneToMany(mappedBy = "session" )
    private List<RegSession> regSessions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private int sessionId;

    @ManyToOne
    @JoinColumn(name = "sub_id", referencedColumnName = "sub_id")
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @NotBlank
    @Column(name = "session_title", nullable = false, length = 90)
    private String sessionTitle;

    @NotBlank
    @Column(name = "session_snum", nullable = false)
    private int sessionSnum;

    @Column(name = "session_sdate", columnDefinition = "DATETIME")
    private LocalDateTime sessionSdate;

    @Column(name = "session_edate", columnDefinition = "DATETIME")
    private LocalDateTime sessionEdate;

    // Getters and setters
}

