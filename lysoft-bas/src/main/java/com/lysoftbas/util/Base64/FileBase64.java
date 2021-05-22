package com.lysoftbas.util.Base64;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * lysoft
 * Creat by zmy on 2021-05-13 15:38
 */
public class FileBase64 {

    public String transtoBase64(String filePath){
        String base64 = null;
        //        String filePath = "E:/26f2.png";
        if (filePath == null) {
            System.out.println("filePath:为null");
        }
        try {
            File file = new File(filePath);

            byte[] b = Files.readAllBytes(Paths.get(filePath));
            //            System.out.println("byte[]"+ Arrays.toString(b));
            base64= Base64.getEncoder().encodeToString(b);
            //            System.out.println("文件转base64"+base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "data:image/jpeg;base64,"+base64;
    }


}
