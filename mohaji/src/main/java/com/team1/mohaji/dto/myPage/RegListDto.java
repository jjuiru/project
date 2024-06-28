package com.team1.mohaji.dto.myPage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegListDto {
        private int memberId;
        private int subId;
        private String rcStat;
        private BigDecimal rcProgress;
        private String subName;
        private String subType;
        private int subScount;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime subSdate;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDateTime subEdate;
}

