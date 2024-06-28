package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

//과제제출정보
@Entity
@Table(name = "reg_asgn")
public class RegAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ra_id")
    private int raId;

    @ManyToOne(optional = true) //비식별
    @JoinColumn(name = "asgn_id",  referencedColumnName = "asgn_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sub_id", referencedColumnName = "sub_id"),
            @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    })
    private RegCourse regCourse;




    @Column(name = "attached_id") // attached 테이블에서 select
    private Integer attachedId;

    @Column(name = "ra_content", length = 4000)
    private String raContent;

    @Column(name = "ra_sdate")
    private Timestamp raSdate;

    @NotBlank
    @Column(name = "ra_score", nullable = false, columnDefinition = "int default 0")
    private Integer raScore;

    @Column(name = "ra_feedback", length = 4000)
    private String raFeedback;



    // Getters and setters
}
