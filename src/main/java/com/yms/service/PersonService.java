package com.yms.service;

import com.yms.domain.Person;

import java.util.ArrayList;



/**
 * 这是数据仓库业务层接口
 * @created by yangmingsen on 2018/6/3
 */
public interface PersonService {

    /**
     * 读取数据仓库的数据
     * @return ArrayList<Person>
     */
    ArrayList<Person> readPerson();

    /**
     * 写入数据到数据仓库
     * @return null
     */
    void writePersion(ArrayList<Person> per);

}
