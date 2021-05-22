package com.lysoftbas.service;

import com.lysoftbas.entity.UserFile;
import java.util.List;

public interface FileService {
    List<UserFile> findById(Integer id);

    void save(UserFile userFile);


    //根据文件id查询文件
    UserFile findByFileId(Integer fid);


    //更新下载次数
    void updateDownCounts(UserFile userFile);

    //删除文件
    void deleteFile(Integer id);
}
