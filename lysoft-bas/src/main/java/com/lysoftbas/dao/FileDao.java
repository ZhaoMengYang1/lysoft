package com.lysoftbas.dao;

import com.lysoftbas.entity.UserFile;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface FileDao {

    //根据id查询所有
    List<UserFile> findById(@Param("id") Integer id);

    void save(UserFile userFile);

    //根据文件id查询文件
    UserFile findByFileId(Integer fid);

    //更新下载次数
    void updateDownCounts(UserFile userFile);

    //删除文件
    void deleteFile(Integer id);
}
