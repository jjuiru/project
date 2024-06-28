package com.team1.mohaji.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "asgn")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asgn_id")
    private int asgnId;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;

//    @JoinColumn(name = "attached_id", referencedColumnName = "attached_id")
//    private Attached attached; 혜빈님쪽 entity 완성 후

    @Column(name = "asgn_desc", length = 300)
    private String asgnDesc;

    @Column(name = "asgn_sdate", nullable = false)
    private LocalDateTime asgnSdate;

    @Column(name = "asgn_ddate", nullable = false)
    private LocalDateTime asgnDdate;

    @Column(name = "asgn_title", nullable = false, length = 60)
    private String asgnTitle;


}
