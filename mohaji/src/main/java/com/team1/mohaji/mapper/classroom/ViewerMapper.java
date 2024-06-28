package com.team1.mohaji.mapper.classroom;

import com.team1.mohaji.dto.classroom.RegSessionDto;
import com.team1.mohaji.dto.classroom.ViewerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface ViewerMapper {
    public ViewerDto selectViewerInfo(@Param("subId")int subId , @Param("memberId")int memberId, @Param("sessionId")int sessionId);

    public void insertRegSession(@Param("subId")int subId , @Param("memberId")int memberId, @Param("sessionId")int sessionId);

    public int checkRegSession(@Param("subId")int subId , @Param("memberId")int memberId, @Param("sessionId")int sessionId);

    public void updateRegSession(@Param("rsFinal") int rsFinal, @Param("rsMax")int rsMax, @Param("subId")int subId , @Param("memberId")int memberId, @Param("sessionId")int sessionId);

    public RegSessionDto selectRegSession(@Param("subId")int subId , @Param("memberId")int memberId, @Param("sessionId")int sessionId);
}

