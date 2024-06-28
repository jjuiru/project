package com.team1.mohaji.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionDto {
    private int sessionId;
    private String sessionTitle;
    private int sessionSnum;
    private LocalDateTime sessionSdate;
    private LocalDateTime sessionEdate;
    private int subId; // Assuming you need only the ID for simplicity
    private int videoId;   // Assuming you need only the ID for simplicity
}
