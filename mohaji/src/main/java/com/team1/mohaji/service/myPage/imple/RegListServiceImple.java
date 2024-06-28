package com.team1.mohaji.service.myPage.imple;


import com.team1.mohaji.dto.myPage.CreditDto;
import com.team1.mohaji.dto.myPage.RegListDto;
import com.team1.mohaji.mapper.myPage.RegListMapper;
import com.team1.mohaji.service.myPage.RegListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegListServiceImple implements RegListService {
    @Autowired
    RegListMapper regListMapper;

    @Override
    public List<RegListDto> regListInProgress(int memberId) {
        List<RegListDto> rcList = regListMapper.selectRegList(memberId);
        return rcList;
    }

    @Override
    public CreditDto selectCredits(int memberId) {
        CreditDto creditDto = regListMapper.selectCredits(memberId);
        return creditDto;
    }


}



