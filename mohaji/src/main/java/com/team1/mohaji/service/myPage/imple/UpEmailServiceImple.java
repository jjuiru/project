package com.team1.mohaji.service.myPage.imple;

import com.team1.mohaji.mapper.myPage.ReEmailMapper;
import com.team1.mohaji.service.myPage.UpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpEmailServiceImple implements UpEmailService {
    @Autowired
    ReEmailMapper reEmailMapper;

    @Override
    public void updateEmail(int memberId, String email) {
        reEmailMapper.updateEmail(memberId, email);
    }

    @Override
    public String selectEmail(int memberId) {
        return reEmailMapper.selectEmail(memberId);
    }

}

