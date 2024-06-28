package com.team1.mohaji.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegCourseDto {

    private int memberId;
    private int subId;
    private String ccId;
    private String rcStat;
    private BigDecimal rcProgress;
    private Integer rcAsgnScore;
    private Integer rcAttScore;
    private String rcGrade;
}
