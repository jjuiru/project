package com.team1.mohaji.mapper.classroom;

import com.team1.mohaji.dto.classroom.HomeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeMapper {
    public List<HomeDto> selectRegSessionList(@Param("subId")int subId , @Param("memberId")int memberId);
}

