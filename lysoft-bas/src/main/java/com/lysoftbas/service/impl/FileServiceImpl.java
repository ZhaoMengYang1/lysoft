package com.lysoftbas.service.impl;

import com.lysoftbas.entity.UserFile;
import com.lysoftbas.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private com.lysoftbas.dao.FileDao FileDao;

    @Override
    public List<UserFile> findById(Integer id) {
        return FileDao.findById(id);
    }

    @Override
    public void save(UserFile userFile) {

        //是否是图片
        String isImg=userFile.getType().startsWith("image")?"是":"否";

        //下载次数

        userFile.setDowncounts(0);

        //上传时间
        userFile.setUploadTime(new Date());

        //是否是图片
        userFile.setIsImg(isImg);

        FileDao.save(userFile);
    }


    @Override
    public UserFile findByFileId(Integer fid) {
        return FileDao.findByFileId(fid);
    }

    @Override
    public void updateDownCounts(UserFile userFile) {
        FileDao.updateDownCounts(userFile);
    }

    @Override
    public void deleteFile(Integer id) {
        FileDao.deleteFile(id);
    }
}
