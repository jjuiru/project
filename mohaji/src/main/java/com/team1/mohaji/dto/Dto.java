package com.team1.mohaji.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Dto {
    private long num;
    private String email;
    private String id;
    private String name;
    private String password;
    private String role;
    private String createdAt;
}
