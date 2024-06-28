package com.team1.mohaji.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="members", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"login_id", "email"})
})
public class Member extends BaseEntity {

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Professor professor;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private int memberId;

    @NotBlank
    @Size(min=5, message="아이디는 5글자 이상이어야 합니다")
    @Column(name="login_id", nullable = false, unique = true)
    private String loginId;

    @NotBlank
    @Size(min=5, message="비밀번호는 5글자 이상이어야 합니다")
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-zA-Z]).{5,}$", message="비밀번호는 최소 하나의 숫자와 하나의 문자를 포함해야 합니다")
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @Column(name="password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Role role;

    @NotBlank
    @Size(min=2)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Email(message = "이메일 형식을 확인해주세요")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name="email_confirmed", columnDefinition = "boolean default false")
    private boolean emailConfirmed;

    @NotBlank
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "010-0000-0000 형태로 입력해주세요")
    @Column(nullable = false)
    private String phone;

    @Column(name="last_login")
    private LocalDateTime lastLogin;

    @Column(name="login_fail_count", columnDefinition = "int default 0")
    @Max(value = 5)
    @Min(value = 0)
    private int loginFailCount;

    @Column(name="lock_out_enabled", columnDefinition = "boolean default false")
    private boolean lockOutEnabled;

}
