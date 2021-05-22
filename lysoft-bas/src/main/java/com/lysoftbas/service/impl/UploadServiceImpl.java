package com.lysoftbas.service.impl;

import com.lysoftbas.service.UploadService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import sun.misc.BASE64Decoder;

/**
 * upgradrevice
 * Creat by Lyb on 2021-04-20 11:00
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Override
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
        return "成功";
    }

    @Override
    public void testGet() {
        System.out.println("UploadServiceImpl  testGet");
    }


    public String decryptByBase64(String base64, String filePath) {
        // 生成文件名
        String files = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                .format(new Date())
                + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                + ".png";

        if (base64 == null && filePath == null) {
            return "生成文件失败，请给出相应的数据。";
        }
        // 生成文件路径
        filePath = "D:/profile/234/face/67/";
        String filename = filePath + files;
        try {
            Files.write(Paths.get(filename), Base64.getDecoder().decode(base64), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "指定路径下生成文件成功！";
    }


    @Override
    public void uploadBase64(String base64data) {
        BASE64Decoder decoder = new BASE64Decoder();
        // Base64解码
        byte[] imageByte = null;
        try {
            imageByte = decoder.decodeBuffer(base64data);
            for (int i = 0; i < imageByte.length; ++i) {
                if (imageByte[i] < 0) {// 调整异常数据
                    imageByte[i] += 256;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 生成文件名
        String files = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                .format(new Date())
                + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                + ".png";
        // 生成文件路径
        String filename = "d:/" + files;
        try {
            // 生成文件
            File imageFile = new File(filename);
            imageFile.createNewFile();
            if(!imageFile.exists()){
                imageFile.createNewFile();
            }
            OutputStream imageStream = new FileOutputStream(imageFile);
            imageStream.write(imageByte);
            imageStream.flush();
            imageStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
