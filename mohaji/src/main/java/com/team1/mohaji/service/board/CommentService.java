package com.team1.mohaji.service.board;


import com.team1.mohaji.repository.CommentRepository;
import com.team1.mohaji.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;


}
