package com.team1.mohaji.service.board;

import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.repository.BoardRepository;
import com.team1.mohaji.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Board> selectAll(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    public List<Post> getPostsByBoardId(int boardId) {
        return postRepository.findByBoardIdOrderByCreatedAtDesc(boardId);
    }
    public List<Post> getPostsPage(int boardId, int limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.by("createdAt").descending());
        return postRepository.findByBoardId(boardId, pageable).getContent();
    }

    public String getBoardName(int boardId) {
        switch (boardId) {
            case 2:
                return "assignment";
            case 1:
                return "notice";
            case 3:
                return "question";
            case 4:
                return "resource";
            default:
                return null;
        }
    }
}
