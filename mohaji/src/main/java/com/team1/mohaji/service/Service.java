package com.team1.mohaji.service;

import com.team1.mohaji.dto.Dto;

import java.util.List;


public interface Service {

    public Dto findMemberByNum(long num);

    public List<Dto> selectMemberList();

}
