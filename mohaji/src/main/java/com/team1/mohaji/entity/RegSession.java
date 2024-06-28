package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "reg_session")
public class RegSession {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "member_id", referencedColumnName = "member_id"),
            @JoinColumn(name = "sub_id", referencedColumnName = "sub_id")
    })
    private RegCourse regCourse;

    @Id
    @ManyToOne
    @JoinColumn(name = "session_Id", referencedColumnName = "session_Id")
    private Session session;

    @NotBlank
    @Column(name = "rs_progress", nullable = false, precision = 4, scale = 1, columnDefinition = "int default 0")
    private BigDecimal rsProgress;

    @NotBlank
    @Column(name = "rs_max", nullable = false, columnDefinition = "int default 0")
    private int rsMax;

    @NotBlank
    @Column(name = "rs_final", nullable = false, columnDefinition = "int default 0")
    private int rsFinal;

    // Getters and setters
}
