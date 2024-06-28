package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.mapping.ToOne;

import java.sql.Timestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "reg_detail")
public class RegDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rd_id")
    private int rdId;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "member_id", referencedColumnName = "member_id"),
            @JoinColumn(name = "sub_id", referencedColumnName = "sub_id")
    })
    private RegCourse regCourse;

    @NotBlank
    @Column(name = "rd_adate", nullable = false)
    private Timestamp rdAdate;

    @Column(name = "rd_cdate")
    private Timestamp rdCdate;

    @Column(name = "rd_creason", length = 100)
    private String rdCreason;

}
