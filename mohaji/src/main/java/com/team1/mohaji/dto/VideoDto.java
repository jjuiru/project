package com.team1.mohaji.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class VideoDto {
        private int id;
        private String desc;
        private int length;
        private String title;
        private String ycode;
}
