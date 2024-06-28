package com.team1.mohaji.service.classroom;

import com.team1.mohaji.dto.classroom.RegSessionDto;
import com.team1.mohaji.dto.classroom.ViewerDto;

public interface ViewerService {
    public ViewerDto selectViewerInfo(int subId, int memberId, int sessionId);

    public void renewRegSession(RegSessionDto regSessionDto);

}
