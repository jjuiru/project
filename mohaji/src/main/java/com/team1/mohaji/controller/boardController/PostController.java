package com.team1.mohaji.controller.boardController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.config.MemberDetails;
import com.team1.mohaji.dto.PostDto;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Member;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.model.model;
import com.team1.mohaji.repository.BoardRepository;
import com.team1.mohaji.repository.MemberRepository;
import com.team1.mohaji.service.MemberService;
import com.team1.mohaji.service.board.BoardService;
import com.team1.mohaji.service.board.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class PostController {

    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails.getName());
        model.addAttribute("name", customUserDetails.getName());
    }

    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberService memberService;

    @PostMapping("/write")
    public String write(@RequestParam("boardId") int boardId,Model model){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            String boardName = board.getBoardName();
            model.addAttribute("boardId", boardId);
            model.addAttribute("boardName", boardName);
        }
        return "view/board/writeForm";
    }

    @PostMapping("/newPost")
    public String insertPost(@RequestParam("boardId") int boardId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("files") List<MultipartFile> files,
                             @AuthenticationPrincipal CustomUserDetails customUserDetails,
                             Model model){
        System.out.println(boardId);
        String boardName = boardService.getBoardName(boardId);
        int memberId = customUserDetails.getMemberId();
        String userRole = customUserDetails.getRole();

        boolean hasPermission = checkPermission(boardId, userRole);
        if (!hasPermission) {
            return "/view/error"; // 권한이 없을 경우 /error 페이지로 포워드
        }

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setMemberId(memberId);
        newPost.setViews(0);
        newPost.setBoardId(boardId);
        LocalDateTime createdAt = LocalDateTime.now();
        newPost.setCreatedAt(createdAt);
        model.addAttribute("files", files);

        try {
            postService.insertPost(newPost, files, memberId);
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리 로직 추가
        }
        return "redirect:/" +boardName;
    }

    private boolean checkPermission(int boardId, String userRole) {
        switch (boardId) {
            case 1: // 관리자만
                return "ADMIN".equals(userRole);
            case 2: // 교수만
                return "PROFESSOR".equals(userRole);
            case 3: // 누구나
                return true;
            case 4: // 누구나
                return true;
            default:
                return false;
        }
    }

    @GetMapping("/postDetail")
    public String postDetail(@RequestParam("postId") Integer postId, Model model) {
        postService.incrementPostViews(postId);
        PostDto postDto = postService.getPostDetail(postId);
        postDto.setContent(postDto.getContent().replace("\n", "<br>"));
        model.addAttribute("post", postDto);
        String boardName = boardService.getBoardName(postDto.getBoardId());
        model.addAttribute("boardName", boardName);
        return "view/board/postDetail";
    }

    @PostMapping("/updateForm")
    public String showUpdateForm(@RequestParam("postId") int postId, Model model) {
        Post existingPost = postService.getPostById(postId);
        System.out.println(existingPost);
        model.addAttribute("existingPost", existingPost);
        return "view/board/updateForm";
    }

    @PostMapping("/updatePost")
    public String update(@ModelAttribute Post post) {
        // 로그인한 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                currentUserName = ((UserDetails) principal).getUsername();
            } else {
                currentUserName = principal.toString();
            }
        }

        // 로그인한 사용자 ID 가져오기
        Integer loggedInUserId = memberService.findUserIdByUsername(currentUserName);

        // 기존 포스트 가져오기
        Post existingPost = postService.getPostById(post.getPostId());

        // 작성자 ID와 비교
        if (existingPost != null && existingPost.getMemberId().equals(loggedInUserId)) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setUpdatedAt(LocalDateTime.now());
            postService.updatePost(existingPost);
            return "redirect:/postDetail?postId=" + existingPost.getPostId();
        } else {
            // 권한이 없거나 포스트가 존재하지 않는 경우
            System.err.println("Unauthorized update attempt by user ID: " + loggedInUserId);
            return "view/error2"; // 적절한 에러 페이지로 리디렉트
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("postId") int postId) {
        PostDto postDto = postService.getPostDetail(postId);
        String boardName = boardService.getBoardName(postDto.getBoardId());
        postService.deletePost(postId);
        return "redirect:/" + boardName;
    }

}