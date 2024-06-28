package com.team1.mohaji.dto;

import lombok.Data;

@Data
public class AttachedDto {

    private int attachedId;
    private int serialId;
    private int postId;
    private int memberId;
    private String storagePath;
    private String originalName;
    private String savedName;
    private String attachedType;
    private Long attachedSize;
    private int downloads;

}
