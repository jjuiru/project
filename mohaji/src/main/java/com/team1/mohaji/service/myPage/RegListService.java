package com.team1.mohaji.service.myPage;


import com.team1.mohaji.dto.myPage.CreditDto;
import com.team1.mohaji.dto.myPage.RegListDto;
import org.springframework.stereotype.Service;


import java.util.List;

public interface RegListService {

    public List<RegListDto> regListInProgress(int memberId);

    public CreditDto selectCredits(int memberid);
}
