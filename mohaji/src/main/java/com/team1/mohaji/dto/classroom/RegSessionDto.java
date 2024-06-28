package com.team1.mohaji.dto.classroom;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegSessionDto {
    private int rsFinal;
    private int rsMax;
    private int memberId;
    private int subId;
    private int sessionId;

}
