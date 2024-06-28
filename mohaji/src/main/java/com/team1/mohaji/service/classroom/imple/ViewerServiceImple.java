package com.team1.mohaji.service.classroom.imple;

import com.team1.mohaji.dto.classroom.RegSessionDto;
import com.team1.mohaji.dto.classroom.ViewerDto;
import com.team1.mohaji.mapper.classroom.ViewerMapper;
import com.team1.mohaji.service.classroom.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewerServiceImple implements ViewerService {

    @Autowired
    ViewerMapper viewerMapper;

    @Override
    public ViewerDto selectViewerInfo(int subId, int memberId, int sessionId) {
           int dataCount = viewerMapper.checkRegSession(subId, memberId, sessionId);
           if(dataCount == 0){
               viewerMapper.insertRegSession(subId, memberId, sessionId);
           }
        ViewerDto viewerDto = viewerMapper.selectViewerInfo(subId, memberId, sessionId);

        return viewerDto;
    }

    @Override
    public void renewRegSession(RegSessionDto regSessionDto) {
    viewerMapper.updateRegSession(
            regSessionDto.getRsFinal(),
            regSessionDto.getRsMax(),
            regSessionDto.getSubId(),
            regSessionDto.getMemberId(),
            regSessionDto.getSessionId());
    }



}
