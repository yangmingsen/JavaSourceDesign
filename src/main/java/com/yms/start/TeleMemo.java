package com.yms.start;

import com.yms.comm.ServiceFactory;
import com.yms.domain.Friend;
import com.yms.domain.Kinsfolk;
import com.yms.domain.Person;
import com.yms.domain.Teacher;
import com.yms.service.impl.FriendServiceImpl;

import java.io.*;
import java.util.ArrayList;

public class TeleMemo {

    private ArrayList<Person> perList;

    public TeleMemo() {
        this.perList = new ArrayList<Person>();
        this.getDataFromRepos();
    }

    private void getDataFromRepos() {
        this.perList.addAll(ServiceFactory.getTeacherService().readPerson());
        this.perList.addAll(ServiceFactory.getFriendService().readPerson());
        this.perList.addAll(ServiceFactory.getKinsfolkService().readPerson());
    }

    public static void main(String[] args) {
        TeleMemo tel = new TeleMemo();

    }


}
