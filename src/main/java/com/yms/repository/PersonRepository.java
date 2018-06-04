package com.yms.repository;

import com.yms.domain.Person;

import java.util.ArrayList;

/**
 * 这是用户数据读取仓库接口
 * @author created by yangmingsen on 2018/6/3
 */
public interface PersonRepository {

    ArrayList<Person> readPerson();

    void writePersion(ArrayList<Person> per);
}
