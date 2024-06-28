package com.team1.mohaji.service.classroom;

import com.team1.mohaji.dto.classroom.HomeDto;
import com.team1.mohaji.dto.classroom.RegSessionDto;


import java.util.List;

public interface HomeService {

    public List<HomeDto> sessionListInProgress(int subId, int memberId);


}
