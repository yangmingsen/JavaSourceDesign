package com.yms.service.impl;

import com.yms.domain.Person;
import com.yms.repository.impl.PersonKinsfolkRepositoryImpl;
import com.yms.service.PersonService;

import java.util.ArrayList;

/**
 * 这是Friend业务层实现类,包含注入PersonKinsfolkRepositoryImpl所有的底层实现.
 * 由于该类只能有一个,该类被设计为单例模式.
 *
 * @author created by yangmingsen on 2018/6/3
 */
public class KinsfolkServiceImpl implements PersonService {

    private PersonKinsfolkRepositoryImpl perKinRepos;
    private static final KinsfolkServiceImpl singleKinsfolk = new KinsfolkServiceImpl();

    private KinsfolkServiceImpl() {perKinRepos = new PersonKinsfolkRepositoryImpl();}

    public static KinsfolkServiceImpl getInstance() {
        return singleKinsfolk;
    }


    public ArrayList<Person> readPerson() {
       return perKinRepos.readPerson();
    }

    public void writePersion(ArrayList<Person> per) {
        perKinRepos.writePersion(per);
    }
}
