package com.team1.mohaji.service.classroom.imple;

import com.team1.mohaji.config.FileStorageProperties;
import com.team1.mohaji.dto.classroom.AssignmentDto;
import com.team1.mohaji.dto.classroom.RegAssignmentDto;
import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.mapper.classroom.AssignmentRoomMapper;
import com.team1.mohaji.repository.AttachedRepository;
import com.team1.mohaji.service.classroom.AssignmentRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AssignmentRoomServiceImple implements AssignmentRoomService {

    private final Path fileStorageLocation;

    @Autowired
    AssignmentRoomMapper assignmentRoomMapper;

    @Autowired
    AttachedRepository attachedRepository;
    public AssignmentRoomServiceImple(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
    public void updateRegAsgn(RegAssignmentDto regAssignmentDto, MultipartFile file){
        if(!file.isEmpty())
            regAssignmentDto.setAttachedId(attachedRepository.findMaxAttachedId() + 1);

        assignmentRoomMapper.updateRegAsgn(regAssignmentDto);
        if (!file.isEmpty()) {
            try {
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
                attached.setMemberId(regAssignmentDto.getMemberId()); // memberId 설정

                // Save the attached file information to the database
                attachedRepository.save(attached);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public int countRegAsgn(int memberId,int subId , int asgnId){
        int result = assignmentRoomMapper.countRegAsgn(memberId, subId, asgnId);
        return result;
    }


    @Override
    public AssignmentDto selectAssignment(int asgnId) {
        AssignmentDto asgn = assignmentRoomMapper.selectAssignment(asgnId);
        return asgn;
    }
    @Override
    public List<AssignmentDto> selectAssignmentList(int memberId) {
        List<AssignmentDto>asgnList = assignmentRoomMapper.selectAssignmentList(memberId);
        return asgnList;
    }

    @Override
    public String selectSubName(int subId) {
        String subName = assignmentRoomMapper.selectSubName(subId);
        return subName;
    }


    @Override
    public void insertRegAsgn(RegAssignmentDto regAssignmentDto, MultipartFile file) {
        if(!file.isEmpty())
            regAssignmentDto.setAttachedId(attachedRepository.findMaxAttachedId() + 1);
        assignmentRoomMapper.insertRegAsgn(
                regAssignmentDto.getMemberId(),
                regAssignmentDto.getSubId(),
                regAssignmentDto.getAsgnId(),
                regAssignmentDto.getRaContent(),
                regAssignmentDto.getAttachedId());
        if (!file.isEmpty()) {
            try {
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
                attached.setMemberId(regAssignmentDto.getMemberId()); // memberId 설정

                // Save the attached file information to the database
                attachedRepository.save(attached);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public RegAssignmentDto selectRegAsgn(int memberId, int subId, int asgnId) {
        RegAssignmentDto regAssignmentDto = assignmentRoomMapper.selectRegAsgn(memberId, subId, asgnId);
        return regAssignmentDto;
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
}
