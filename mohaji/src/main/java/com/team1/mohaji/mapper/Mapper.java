package com.team1.mohaji.mapper;

import com.team1.mohaji.dto.Dto;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
    public interface Mapper {
        public Dto selectMemberByNum(long num);
        public List<Dto> selectMemberList();
}
