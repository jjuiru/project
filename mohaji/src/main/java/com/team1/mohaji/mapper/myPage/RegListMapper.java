package com.team1.mohaji.mapper.myPage;


import com.team1.mohaji.dto.myPage.CreditDto;
import com.team1.mohaji.dto.myPage.RegListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegListMapper {
    public List<RegListDto> selectRegList(int memberId);
    public CreditDto selectCredits(int memberId);
}
