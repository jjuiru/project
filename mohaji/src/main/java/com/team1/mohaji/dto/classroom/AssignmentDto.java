package com.team1.mohaji.dto.classroom;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssignmentDto {
    private int asgnId;
    private String asgnTitle;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime asgnDdate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime asgnSdate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime raSdate;
    private int raScore;
    private String status;
    private String asgnDesc;

    public int getAsgnId() {
        return asgnId;
    }

    public String getAsgnTitle() {
        return asgnTitle;
    }

    public LocalDateTime getAsgnDdate() {
        return asgnDdate;
    }

    public LocalDateTime getAsgnSdate() {
        return asgnSdate;
    }

    public LocalDateTime getRaSdate() {
        return raSdate;
    }

    public int getRaScore() {
        return raScore;
    }

    public String getStatus() {
        return status;
    }

    public String getAsgnDesc() {
        return asgnDesc;
    }

    public String getFormattedAsgnSdate() {
        return asgnSdate.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getFormattedAsgnDdate() {
        return asgnDdate.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}
