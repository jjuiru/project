package com.team1.mohaji.service.myPage.imple;

import com.team1.mohaji.dto.myPage.MyPCDto;
import com.team1.mohaji.mapper.myPage.MyPCMapper;
import com.team1.mohaji.service.myPage.MyPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPCSericeImple implements MyPCService {
    @Autowired
    MyPCMapper myPCMapper;


    @Override
    public List<MyPCDto> selectIP(int memberId) {
        return myPCMapper.selectIP(memberId);
    }

    @Override
    public void updatePCName(String mipName, int memberId, String mipIp) {
            myPCMapper.updatePCName(mipName, memberId,mipIp);

    }


    @Override
    public void insertIP(String mipName, int memberId, String mipIp) {
    myPCMapper.insertIP(mipName, memberId, mipIp);
    }

    @Override
    public void deleteIP(int mipId) {
    myPCMapper.deleteIP(mipId);
    }
}
