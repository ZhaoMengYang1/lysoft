package com.IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import sun.misc.BASE64Encoder;

/**
 * lysoft
 * Creat by zmy on 2021-05-13 14:19
 */
public class Base64Test {


    @Test
    public void transToBase64() throws Exception {
        String path = "D:\\26f2.png";
        String path2 = "F:\\home\\swkj\\faceResource\\lfw-bush\\lfw\\George_W_Bush\\George_W_Bush_0005.jpg";
        String base64 =transtoBase64(path2);
//        String base64 =encodeBase64File(path2);
        System.out.println("base64:"+base64);
//        byte[] color = Base64.getDecoder().decode(base64);
//        System.out.println("byte[]"+ Arrays.toString(color));
    }

    @Test
    public void BaseDecode(){

    }

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
//        return  "data:image/jpeg;base64,"+base64;
        return  base64;
    }


    /**
     * <p>将文件转成base64 字符串</p>
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }



}
