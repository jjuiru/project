package com.team1.mohaji.entity;

import com.team1.mohaji.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "professors", uniqueConstraints = {
        @UniqueConstraint(columnNames = "prof_code")
})
public class Professor extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false, unique=true)
    private Member member;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id", unique = true)
    private int profId;

    @Column(name = "dept_id", columnDefinition = "int default 1")
    @Min(value=1)
    private int deptId=1;

    @Column(name = "prof_code")
    private String profCode;

    @Column(name = "appointed_date")
    private LocalDateTime appointedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private Title title;


    public enum Title {
        FULL,
        ASSOCIATE,
        ASSISTANT,
        INSTRUCTOR
    }
}
