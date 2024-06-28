package com.team1.mohaji.mapper.myPage;

import com.team1.mohaji.dto.myPage.MyPCDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPCMapper {
    public List<MyPCDto> selectIP(int memberId);
    public void updatePCName(String mipName, int memberId, String mipIp);
    public void insertIP(String mipName, int memberId, String mipIp);
    public void deleteIP(int mipId);

}
