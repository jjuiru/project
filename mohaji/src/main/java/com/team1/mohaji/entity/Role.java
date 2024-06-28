package com.team1.mohaji.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    STUDENT("ROLE_STUDENT", "학생"),
    PROFESSOR("ROLE_PROFESSOR", "교수"),
    ADMIN("ROLE_ADMIN", "교직원");

    private final String key;
    private final String title;

}