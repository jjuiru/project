package com.team1.mohaji.service.myPage.imple;

import com.team1.mohaji.dto.SubjectDto;
import com.team1.mohaji.mapper.main.RegCourseMapper;
import com.team1.mohaji.service.myPage.RegInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegInfoServiceImple implements RegInfoService {
    @Autowired
    RegCourseMapper regCourseMapper;

    @Override
    public void deleteRegInfo(int memberId, int subId) {
        regCourseMapper.deleteRegInfo(memberId, subId);
    }

    @Override
    public List<SubjectDto> selectRegInfoBF(int memberId) {
        return regCourseMapper.selectRegInfoBF(memberId);
    }

    @Override
    public List<SubjectDto> selectRegInfoAT(int memberId) {
        return regCourseMapper.selectRegInfoAT(memberId);
    }

    @Override
    public void updateRCStat(int memberId) {
        regCourseMapper.updateRCStat(memberId);
    }
}
