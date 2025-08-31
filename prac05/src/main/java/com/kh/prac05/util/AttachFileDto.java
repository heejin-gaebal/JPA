package com.kh.prac05.util;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AttachFileDto {
    private Long fileNo;
    private String fileOriginName;
    private String fileSaveName;
    private String filePath;
    private LocalDateTime fileCreatedAt;
    private String fileDelYn;

    public static AttachFileDto from(AttachFileEntity attachFileEntity){
        AttachFileDto attachFileDto = new AttachFileDto();
        attachFileDto.fileNo = attachFileEntity.getFileNo();
        attachFileDto.fileOriginName = attachFileEntity.getFileOriginName();
        attachFileDto.fileSaveName = attachFileEntity.getFileSaveName();
        attachFileDto.filePath = attachFileEntity.getFilePath();
        attachFileDto.fileCreatedAt = attachFileEntity.getFileCreatedAt();
        attachFileDto.fileDelYn = attachFileEntity.getFileDelYn();

        return attachFileDto;
    }
}
