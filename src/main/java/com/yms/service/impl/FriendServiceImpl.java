package com.yms.service.impl;

import com.yms.domain.Person;
import com.yms.repository.impl.PersonFriendRepositoryImpl;
import com.yms.service.PersonService;

import java.util.ArrayList;

/**
 * 这是Friend业务层实现类,包含注入PersonFriendRepositoryImpl所有的底层实现.
 * 由于该类只能有一个,该类被设计为单例模式.
 *
 * @author created by yangmingsen on 2018/6/3
 */
public class FriendServiceImpl implements PersonService {

    private PersonFriendRepositoryImpl perFriRepos;
    private FriendServiceImpl() {perFriRepos = new PersonFriendRepositoryImpl();}
    private static final FriendServiceImpl singleFriend = new FriendServiceImpl();

    public static FriendServiceImpl getInstance() {
        return singleFriend;
    }

    public ArrayList<Person> readPerson() {
        return perFriRepos.readPerson();
    }

    public void writePersion(ArrayList<Person> per) {
        perFriRepos.writePersion(per);
    }
}
