package com.team1.mohaji.service.classroom.imple;
import com.team1.mohaji.dto.classroom.HomeDto;
import com.team1.mohaji.mapper.classroom.HomeMapper;
import com.team1.mohaji.service.classroom.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImple implements HomeService {
    @Autowired
    HomeMapper homeMapper;

    @Override
    public List<HomeDto> sessionListInProgress(int subId, int memberId) {
        List<HomeDto> rsList = homeMapper.selectRegSessionList(subId, memberId);
        return rsList;
    }
}



