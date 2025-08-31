package com.kh.prac05.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class AttachFileUploader {

    public static String saveFile(MultipartFile file, String dirPath) throws IOException {
        String originName = file.getOriginalFilename();
        int idx = originName.lastIndexOf(".");

        String ext = originName.substring(idx);
        String changeName = System.currentTimeMillis() + "_" + UUID.randomUUID() + ext;

        String savePath = dirPath + changeName;
        File targetFile = new File(savePath);
        file.transferTo(targetFile);

        return changeName;
    }
}
