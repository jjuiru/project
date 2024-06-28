package com.team1.mohaji.dto.classroom;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HomeDto {
        private int memberId;
        private int sessionId;
        private String sessionSnum;
        private String sessionTitle;
        private String rsProgress;
        private String subId;
        private String videoYcode;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime sessionSdate;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime sessionEdate;

}
