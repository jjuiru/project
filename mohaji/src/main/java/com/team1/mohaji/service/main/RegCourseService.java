package com.team1.mohaji.service.main;

import com.team1.mohaji.dto.RegCourseDetailDto;
import com.team1.mohaji.dto.SubjectDto;

import java.util.List;


public interface RegCourseService {

    public List<SubjectDto> selectAllSubject(String memberId);

    public List<SubjectDto> selectCategory(String category, String memberId);

    public List<SubjectDto> selectAllSearch(String category, String keyword ,String memberId);

    public List<SubjectDto> selectKeyword(String keyword , String memberId);

    public List<SubjectDto> selectSubjectByRegStat(int memberId);

    public String selectRegCourseByRegStat(int memberId, int subId);

    RegCourseDetailDto regCourseDetail(int subId);

    public int selectCreditSum(int memberId);

    public void insertReg(int memberId, int subId, String rcStat);

    public  void updateRegCourse(int memberId, int subId);



    public int selectCount();

}
