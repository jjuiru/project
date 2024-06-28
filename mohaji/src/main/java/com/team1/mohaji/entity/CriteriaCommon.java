package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "criteria_common")
public class CriteriaCommon {

    @OneToMany(mappedBy = "criteriaCommon") // CriteriaDetail 엔티티의 필드명으로 수정
    private List<CriteriaDetail> criteriaDetails;

    @Id
    @Column(name = "cc_id", length = 30 )
    private String ccId;

    @NotBlank
    @Column(name = "cc_title", nullable = false, length = 60)
    private String ctTitle;

    // Getters and setters
}