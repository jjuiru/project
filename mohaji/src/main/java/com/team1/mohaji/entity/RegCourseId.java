package com.team1.mohaji.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegCourseId implements Serializable {
    private int member_id;
    private int sub_id;

    public RegCourseId() {}

    public RegCourseId(int member_id, int sub_id) {
        this.member_id = member_id;
        this.sub_id = sub_id;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegCourseId that = (RegCourseId) o;
        return Objects.equals(member_id, that.member_id) &&
                Objects.equals(sub_id, that.sub_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member_id, sub_id);
    }

    // Getter, Setter 생략
}
