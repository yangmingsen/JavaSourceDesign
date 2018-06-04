package com.yms.service.impl;

import com.yms.domain.Person;
import com.yms.repository.impl.PersonTeacherRepositoryImpl;
import com.yms.service.PersonService;

import java.util.ArrayList;

/**
 * 这是Friend业务层实现类,包含注入PersonTeacherRepositoryImpl所有的底层实现.
 * 由于该类只能有一个,该类被设计为单例模式.
 *
 * @author created by yangmingsen on 2018/6/3
 */
public class TeacherServiceImpl implements PersonService {

    private PersonTeacherRepositoryImpl perTeaRepos;
    private static final TeacherServiceImpl singleTeacher = new TeacherServiceImpl();

    private TeacherServiceImpl() {perTeaRepos = new PersonTeacherRepositoryImpl();}

    public static TeacherServiceImpl getInstance() {
        return singleTeacher;
    }

    public ArrayList<Person> readPerson() {
        return perTeaRepos.readPerson();
    }

    public void writePersion(ArrayList<Person> per) {
        perTeaRepos.writePersion(per);
    }
}
