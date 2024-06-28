package com.team1.mohaji.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubjectDto {

        private int subId;
        private String deptName;
        private String subName;  //조인 sub
        private String name;  //조인 prof-member
        private String subType;
        private String subDesc;
        private int subScount;
        private int subCredit;
        private String rcStat;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime subEdate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime subRsdate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime subRedate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime subSdate;
        private int memberId;

        // Getters and setters
}
