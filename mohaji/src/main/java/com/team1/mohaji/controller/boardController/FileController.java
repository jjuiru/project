package com.team1.mohaji.controller.boardController;


import com.team1.mohaji.config.FileStorageProperties;
import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.repository.AttachedRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    private final Path fileStorageLocation;
    private final AttachedRepository attachedRepository;

    public FileController(FileStorageProperties fileStorageProperties, AttachedRepository attachedRepository) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        this.attachedRepository = attachedRepository;
    }

    @GetMapping("/download/{idx}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int idx) throws Exception {
        // DB에서 파일 정보 조회 (idx를 이용하여)
        Attached attached = attachedRepository.findById(idx)
                .orElseThrow(() -> new Exception("File not found with id " + idx));

        // 파일의 저장 경로를 가져옴
        Path filePath = fileStorageLocation.resolve(attached.getSavedName()).normalize();

        // 디버깅용 로그
        System.out.println("Resolved file path: " + filePath);

        Resource resource = new UrlResource(filePath.toUri());

        // 디버깅용 로그
        System.out.println("Resource: " + resource);

        if (resource.exists()) {
            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            // 파일 이름을 인코딩
            String encodedFileName = URLEncoder.encode(attached.getOriginalName(), StandardCharsets.UTF_8.toString());

            // 디버깅용 로그
            System.out.println("Content type: " + contentType);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFileName + "\"")
                    .body(resource);
        } else {
            throw new Exception("File not found " + attached.getSavedName());
        }
    }
}

