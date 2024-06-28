package com.mohaji.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohaji.model.Artboard;
import com.mohaji.model.Likelist;
import com.mohaji.repository.ArtboardMapper;
import com.mohaji.repository.MemberMapper;


import java.util.List;

@Service 
public class ArtboardService {

    @Autowired
    private ArtboardMapper artboardMapper;
    
    public List<Artboard> artboardList() {
        return artboardMapper.selectAllArtboard(); }

    public List<Artboard> selectStarAvg(){
        return artboardMapper.selectStarAvg();
    };
    
    public Artboard artboardSelectCode(String popCode) {
        return artboardMapper.selectOneArtboard(popCode); }
    
    public List<Artboard> selDateArtboardList(String date) {
        return artboardMapper.selDateArtboard(date); }
    
    public List<Artboard> selKeyArtboardList(String keyword) {
        return artboardMapper.selKeyArtboardList(keyword); }
}
