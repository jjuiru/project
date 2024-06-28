package com.team1.mohaji.controller.boardController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.PostDto;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.service.board.BoardService;
import com.team1.mohaji.service.board.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails.getName());
        model.addAttribute("name", customUserDetails.getName());
    }

    @Autowired
    private BoardService boardService;
    @Autowired
    private PostService postService;

    @GetMapping("/assignment")
    public String assignmentList(Model model){
        List<PostDto> postDTOs = postService.memberName(2);
        model.addAttribute("posts", postDTOs);
        return "view/board/assignmentBoard";
    }

    @GetMapping(value = {"/notice", "/boardList"})
    public String noticeList(Model model){
        List<PostDto> postDTOs = postService.memberName(1);
        model.addAttribute("posts", postDTOs);
        return "view/board/noticeBoard";
    }



    @GetMapping("/question")
    public String questionList(Model model){
        List<PostDto> postDTOs = postService.memberName(3);
        model.addAttribute("posts", postDTOs);
        return "view/board/questionBoard";
    }


    @GetMapping("/resource")
    public String resourceList(Model model){
        List<PostDto> postDTOs = postService.memberName(4);
        model.addAttribute("posts", postDTOs);
        return "view/board/resourceBoard";
    }

    //게시판 검색기능 추가
    @GetMapping("/search")
    public String search(@RequestParam("board") int boardId,
                         @RequestParam("query") String query,
                         Model model) {
        List<PostDto> postDTOs = postService.searchAndConvertPosts(query, boardId);
        String boardName = boardService.getBoardName(boardId);
        model.addAttribute("posts", postDTOs);
        return "view/board/" + boardName + "Board";
    }




}