package com.team1.mohaji.entity;

import jakarta.persistence.*;

//ip 등록
@Entity
public class MemberIp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mip_id")
    private int mipId;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @Column(name="mip_ip", unique = true, nullable = false)
    private String mipIp;

    @Column(name="mip_name", nullable = false)
    private String mipName;

}