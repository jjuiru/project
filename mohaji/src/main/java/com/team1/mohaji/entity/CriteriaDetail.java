package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "criteria_detail")
public class CriteriaDetail {
    @Id
    @Column(name = "cv_id", length = 30)
    private String cvId;

    @ManyToOne
    @JoinColumn(name = "cc_id") // 외래 키로 사용될 컬럼의 이름을 지정
    private CriteriaCommon criteriaCommon;

    @NotBlank
    @Column(name = "cv_title", nullable = false)
    private String cvTitle;

    @Column(name = "cv_value1")
    private String cvValue1;

    @Column(name = "cv_value2")
    private String cvValue2;

    @Column(name = "cv_value3")
    private String cvValue3;

    @Column(name = "cv_value4")
    private String cvValue4;

    @Column(name = "cv_value5")
    private String cvValue5;

    @Column(name = "cv_desc", length = 300)
    private String cvDesc;
}
