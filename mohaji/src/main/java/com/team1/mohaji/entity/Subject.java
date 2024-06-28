package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @OneToMany(mappedBy = "subject" )
    private List<Session> sessions;
    @OneToMany(mappedBy = "subject" )
    private List<RegCourse> regCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private int subId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    // Assuming Pro is another entity, not provided in SQL
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false)
    private Professor professor;

    @Column(name = "sub_name", nullable = false, length = 90)
    private String subName;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "sub_type", nullable = false)
    private subType subType;

    @Column(name = "sub_desc" , length = 300)
    private String subDesc;

    @NotBlank
    @Column(name = "sub_scount", nullable = false)
    private int subScount;

    @NotBlank
    @Min(0)  // 최소값 제약조건 추가
    @Max(3)
    @Column(name = "sub_credit", nullable = false)
    private int subCredit;

    @Column(name = "sub_rsdate", columnDefinition = "DATETIME")
    private LocalDateTime subRsdate;

    @Column(name = "sub_redate", columnDefinition = "DATETIME")
    private LocalDateTime subRedate;

    @Column(name = "sub_sdate", columnDefinition = "DATETIME")
    private LocalDateTime subSdate;

    @Column(name = "sub_edate", columnDefinition = "DATETIME")
    private LocalDateTime subEdate;

    public enum subType {
        전공필수,
        전공선택,
        교양필수,
        교양선택
    }
}
