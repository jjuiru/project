package com.team1.mohaji.dto;

import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegCourseDetailDto {
        private String deptName;
        private String name;
        private String subName;
        private String subType;
        private String subDesc;
        private List<String> sessionTitle;
        private int credit;

}