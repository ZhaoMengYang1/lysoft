package com.lysoftbas.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * upgradrevice
 * Creat by Lyb on 2021-04-20 10:54
 */
@Controller
public class uploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile aaa) throws IOException {
        //获取文件原始名称
        String oldFileName = aaa.getOriginalFilename();
        System.out.println("文件原始名称" + oldFileName);

        //获取文件后缀
        String extension = "." + FilenameUtils.getExtension(oldFileName);
        System.out.println("文件扩展名" + extension);

        //文件大小
        long size = aaa.getSize();
        //文件类型
        String contentType = aaa.getContentType();
        System.out.println("文件类型" + contentType);

        String dataDirPath = "d:/";
        File dataDir = new File(dataDirPath);

        aaa.transferTo(new File(dataDir, oldFileName));

        return "success";
    }
}
