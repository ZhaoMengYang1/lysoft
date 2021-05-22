package com.lysoftbas.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * upgradrevice
 * Creat by Lyb on 2021-04-20 11:00
 */
public interface UploadService {
    public String upload(MultipartFile aaa) throws IOException;
    public void testGet();
    public void uploadBase64(String base64data);
    public String decryptByBase64(String base64, String filePath);
}
