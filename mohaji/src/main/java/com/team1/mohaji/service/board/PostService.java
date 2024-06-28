package com.team1.mohaji.service.board;

import com.team1.mohaji.config.FileStorageProperties;
import com.team1.mohaji.dto.AttachedDto;
import com.team1.mohaji.dto.PostDto;
import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.repository.AttachedRepository;
import com.team1.mohaji.repository.BoardRepository;
import com.team1.mohaji.repository.MemberRepository;
import com.team1.mohaji.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AttachedRepository attachedRepository;

    private final Path fileStorageLocation;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    public PostService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    private String generateUniqueFileName(String originalFileName) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileExtension = "";
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0) {
            fileExtension = originalFileName.substring(dotIndex);
        }

        return timeStamp + "_" + originalFileName + fileExtension;
    }

    @Transactional
    public void insertPost(Post post, List<MultipartFile> files, int memberId) throws IOException {
        List<Attached> attachments = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String originalFileName = file.getOriginalFilename();
                String saveFileName = generateUniqueFileName(originalFileName);
                Path targetLocation = this.fileStorageLocation.resolve(saveFileName);
                String fileType = file.getContentType();
                Long fileSize = file.getSize();

                Files.copy(file.getInputStream(), targetLocation);

                Attached attached = new Attached();
                attached.setOriginalName(originalFileName);
                attached.setSavedName(saveFileName);
                attached.setAttachedType(fileType);
                attached.setAttachedSize(fileSize);
                attached.setStoragePath(targetLocation.toString());
                attached.setPost(post);
                attached.setMemberId(memberId); // memberId 설정
                attachments.add(attached);

            }
        }
        post.setAttachments(attachments);
        postRepository.save(post);
        attachedRepository.saveAll(attachments);

    }

    @Transactional
    public int deletePost(int postId){
        int result = postRepository.deleteByPostId(postId);
        return result;
    }

    @Transactional
    public void incrementPostViews(Integer postId) {
        postRepository.updateViews(postId);
    }

    // 게시글 제목으로 검색하고 PostDto 리스트로 반환하는 메서드
    public List<PostDto> searchAndConvertPosts(String query, int boardId) {
        List<Post> posts = searchPostsByTitle(query, boardId);
        return convertPostsToDtos(posts);
    }

    // Post 리스트를 PostDto 리스트로 변환하는 메서드
    public List<PostDto> convertPostsToDtos(List<Post> posts) {
        List<PostDto> postDtos = new ArrayList<>();
        int sequenceNumber = posts.size();

        for (Post post : posts) {
            String name = memberRepository.findMemberNameByMemberId(post.getMemberId());
            PostDto postDto = new PostDto();
            postDto.setPostId(post.getPostId());
            postDto.setTitle(post.getTitle());
            postDto.setViews(post.getViews());
            postDto.setCreatedAt(post.getCreatedAt());
            postDto.setMemberId(post.getMemberId());
            postDto.setContent(post.getContent());
            postDto.setMemberName(name);
            postDto.setSequenceNumber(sequenceNumber--); // 순번 설정
            postDto.setBoardId(post.getBoard().getBoardId());
            postDto.setBoardName(post.getBoard().getBoardName());
            postDtos.add(postDto);
        }
        return postDtos;
    }

    // 게시글 제목으로 검색하는 메서드 (Post 리스트 반환)
    public List<Post> searchPostsByTitle(String title, int boardId) {
        return postRepository.findByTitleContainingAndBoardBoardId(title, boardId);
    }

    // 게시판 ID로 게시글을 가져오고 PostDto 리스트로 변환하는 메서드
    public List<PostDto> memberName(int boardId) {
        List<Post> posts = boardService.getPostsByBoardId(boardId);
        return convertPostsToDtos(posts);
    }

    public PostDto getPostDetail(int postId) {

        Post post = postRepository.findByPostId(postId);
        List<Attached> fileList = attachedRepository.findByPost(post);
        String memberName = memberRepository.findMemberNameByMemberId(post.getMemberId());
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setTitle(post.getTitle());
        postDto.setViews(post.getViews());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setMemberId(post.getMemberId());
        postDto.setContent(post.getContent());
        postDto.setMemberName(memberName);
        postDto.setBoardId(post.getBoard().getBoardId());
        postDto.setBoardName(post.getBoard().getBoardName());
        postDto.setUpdatedAt(post.getUpdatedAt());
        postDto.setUpdatedName(postDto.getUpdatedName());
        postDto.setAttachments(fileList);
        return postDto;
    }

    public void updatePost(Post updatedPost) {
        Post existingPost = postRepository.findByPostId(updatedPost.getPostId());
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setUpdatedAt(LocalDateTime.now());
        postRepository.save(existingPost);
    }

    public Post getPostById(int postId){
        return postRepository.findByPostId(postId);
    }

}
