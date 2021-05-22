package com.IO;

import com.arcsoft.face.toolkit.ImageInfo;
import com.lysoftbas.util.Base64.FileBase64;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

/**
 * lysoft
 * Creat by zmy on 2021-05-13 11:26
 */
public class FileTest {
    /**
     * 后来在网上查找ImageIO用法知道，它可读取的图片类型是有限制的，可以读取图片的格式为：[BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
     * 可是文件后缀是jpg格式,按道理说应该支持啊,后来将文件下载下来放到notepad++上查看才发现前缀是:RIFF? WEBPVP8 这说明该文件的实际格式是webp格式.文件后缀名有时候不是实际的文件格式.
     * @throws IOException
     */
    FileBase64 fileBase64 = new FileBase64();
    @Test
    public void FileTest() throws IOException {
        File sourceimage = new File("F:\\home\\swkj\\faceResource\\lfw-bush\\lfw\\George_W_Bush\\George_W_Bush_0006.jpg");

        ImageInfo imageInfo = getRGBData(sourceimage);
        BufferedImage image = ImageIO.read(sourceimage);
        System.out.println(imageInfo);
        System.out.println(sourceimage.exists());


    }


}
