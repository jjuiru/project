package com.team1.mohaji.dto.classroom;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewerDto {
    private int sessionId;
    private int subId;
    private int memberId;
    private String videoYcode;
    private String videoTitle;
    private int videoLength;
    private String sessionTitle;
    private int sessionSnum;
    private LocalDateTime sessionEdate;
    private int rsFinal;
    private int rsMax;
    private String subName;

}
