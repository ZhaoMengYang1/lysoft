package com.lysoftbas.dao;

import com.lysoftbas.entity.Person;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * upgradrevice
 * Creat by zmy on 2021-04-21 17:00
 */

public interface PersonDao {
    public List<Person> selectAll();
    public int insertPerson(@Param("person") Person person);

}
