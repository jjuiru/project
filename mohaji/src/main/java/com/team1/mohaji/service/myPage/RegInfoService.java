package com.team1.mohaji.service.myPage;

import com.team1.mohaji.dto.SubjectDto;

import java.util.List;

public interface RegInfoService {

    void deleteRegInfo(int memberId, int subId);

    List<SubjectDto> selectRegInfoBF (int memberId);

    List<SubjectDto> selectRegInfoAT (int memberId);

    void updateRCStat(int memberId);


}
