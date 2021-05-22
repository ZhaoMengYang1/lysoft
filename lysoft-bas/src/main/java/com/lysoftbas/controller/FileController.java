package com.lysoftbas.controller;

import com.lysoftbas.entity.User;
import com.lysoftbas.entity.UserFile;
import com.lysoftbas.service.FileService;
import com.lysoftbas.service.UserService;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class FileController {


    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;
/*
    //在线打开
    // 与下载一样，只需要将头部 attachment 改为 inline 即可
    //  response.setHeader("content-disposition","inline;fileName="+ URLEncoder.encode(userFile.getOldFileName(),"UTF-8"));
    @GetMapping("oninline")
    public void oninline(Integer id, HttpServletResponse response) throws IOException {
        //获取文件id获取文件信息
        UserFile userFile = fileService.findByFileId(id);


        //以附件形式下载,      文件名字问原来文件名字
        response.setHeader("content-disposition","inline;fileName="+ URLEncoder.encode(userFile.getOldFileName(),"UTF-8"));

        //根据文件信息中   文件名字和 文件存储路径获取文件输出流
        String realpath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();

        //读取文件输入流
        FileInputStream is = new FileInputStream(new File(realpath, userFile.getNewFileName()));


        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();

        //文件拷贝
        IOUtils.copy(is,os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
    */


//ajax查询所有   定时发送请求 做下载次数更新
    @RequestMapping("/findAllAjax")
    @ResponseBody
    public List<UserFile> findAllAjax(HttpSession session){
        //在登录的session中获取用户的id
        User user = (User) session.getAttribute("user");
        //根据用户id查询有的文件信息
        List<UserFile> userFiles = fileService.findById(user.getId());
        return userFiles;
    }


    //文件刪除 (刪除数据库记录和文件)
    @GetMapping("deleteFile")
    public String deleteFile(Integer id) throws FileNotFoundException {

        //获取文件信息
        UserFile userFile = fileService.findByFileId(id);

        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();

        File file = new File(realPath, userFile.getNewFileName());
        if (file.exists()) file.delete(); //立即删除文件

        //删除数据库数据
        fileService.deleteFile(id);

        return "redirect:show";

    }


    //文件下载  与在线打开  (两个方法合并为一个方法 添加一个参数判断前端传入是否是inline即可)
    @GetMapping("download")
    public void download(String openStyle, Integer id, HttpServletResponse response) throws IOException {

        openStyle = openStyle == null  ? "attachment" : openStyle;
        //获取文件id获取文件信息
        UserFile userFile = fileService.findByFileId(id);


        //点击下载更新下载次数
        if ("attachment".equals(openStyle)) {
            userFile.setDowncounts(userFile.getDowncounts() + 1);
            fileService.updateDownCounts(userFile);
        }

        //以附件形式下载,      文件名字问原来文件名字
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(userFile.getOldFileName(), "UTF-8"));

        //根据文件信息中   文件名字和 文件存储路径获取文件输出流
        String realpath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();

        //读取文件输入流
        FileInputStream is = new FileInputStream(new File(realpath, userFile.getNewFileName()));


        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();

        //文件拷贝
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }


    /**
     * 上传文件处理 并保存文件信息到数据库中
     */
    @PostMapping("/uploadFile")
    public String fileUpload(MultipartFile aaa) throws IOException {

        //获取文件原始名称
        String oldFileName = aaa.getOriginalFilename();
        System.out.println("文件原始名称" + oldFileName);
        String type =aaa.getContentType();
        System.out.println("文件类型" + type);
        //获取文件后缀
        String extension = "." + FilenameUtils.getExtension(oldFileName);
        System.out.println("文件扩展名" + extension);

        //生成新的文件名称
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "") + extension;
        System.out.println("新文件名称" + newFileName);

        //文件大小
        long size = aaa.getSize();

        //文件类型
        String contentType = aaa.getContentType();
        System.out.println("文件类型" + contentType);


        //处理根据日期生成目录
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println("文件路径" + path);
        String realPath = path + "static/files/";
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dataDirPath = realPath + dateFormat;
        File dataDir = new File(dataDirPath);
        //不存在，则创建
        if (!dataDir.exists()) dataDir.mkdir();


        //文件上传
        aaa.transferTo(new File(dataDir, newFileName));



        return "redirect:show";
    }

}
