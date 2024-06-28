package com.team1.mohaji.entity;

import com.team1.mohaji.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
@ToString
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = "student_code")
})
public class Student extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false, unique=true)
    private Member member;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "dept_id", columnDefinition = "int default 1")
    @Min(value=1)
    private int deptId=1;

    @Column(name = "student_code", unique = true)
    private String studentCode;

    @Column(name = "admission_date")
    private LocalDateTime admissionDate;

    @Column(name = "year")
    @Min(value=1)
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(name = "reg_status")
    private RegStatus regStatus;

    @Column(name = "graduation_date")
    private LocalDateTime graduationDate;


    public enum RegStatus {
        ENROLLED, //등록
        NEWLY_ADMITTED, //신입
        GRADUATED, //졸업
        LEAVE_OF_ABSENCE, //휴학
        WITHDRAWN, //자퇴

        //이 정도만 할게요!
    }
}
