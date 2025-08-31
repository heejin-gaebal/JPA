package com.kh.prac05.util;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class AttachFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileNo;

    @Column(nullable = false)
    private String fileOriginName;

    @Column(nullable = false)
    private String fileSaveName;


    @Column(nullable = false)
    private String filePath;

    private LocalDateTime fileCreatedAt;
    private String fileDelYn;

    public AttachFileEntity() {
        fileDelYn = "N";
        fileCreatedAt = LocalDateTime.now();
    }

    public static AttachFileEntity from(AttachFileDto attachFileDto){
        AttachFileEntity attachFileEntity = new AttachFileEntity();
        attachFileEntity.fileOriginName = attachFileDto.getFileOriginName();
        attachFileEntity.fileSaveName = attachFileDto.getFileSaveName();
        attachFileEntity.filePath = attachFileDto.getFilePath();

        return attachFileEntity;
    }


}
