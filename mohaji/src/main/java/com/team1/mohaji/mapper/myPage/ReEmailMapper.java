package com.team1.mohaji.mapper.myPage;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReEmailMapper {

    public void updateEmail(int memberId, String email);

    public String selectEmail(int memberId);
}
