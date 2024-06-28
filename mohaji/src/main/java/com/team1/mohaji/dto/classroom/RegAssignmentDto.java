package com.team1.mohaji.dto.classroom;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegAssignmentDto {
    private int raId;
    private Integer attachedId;
    private String raContent;
    private String raFeedback;
    private int raScore;
    private LocalDateTime raSdate;
    private int asgnId;
    private int memberId;
    private int subId;
}
