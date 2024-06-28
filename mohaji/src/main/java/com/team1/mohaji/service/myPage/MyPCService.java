package com.team1.mohaji.service.myPage;

import com.team1.mohaji.dto.myPage.MyPCDto;

import java.util.List;

public interface MyPCService {
    public List<MyPCDto> selectIP(int memberId);
    public void updatePCName(String mipName, int memberId, String mipIp);
    public void insertIP(String mipName, int memberId, String mipIp);
    public void deleteIP(int mipId);
}
