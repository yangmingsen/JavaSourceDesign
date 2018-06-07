package com.yms.start;

import com.yms.comm.ServiceFactory;
import com.yms.domain.Friend;
import com.yms.domain.Kinsfolk;
import com.yms.domain.Person;
import com.yms.domain.Teacher;
import com.yms.gui.TeleIndexFrame;
import com.yms.utils.sort.SortPersonByPhone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class TeleMemo {

    private ArrayList<Person> perList;
    private static final TeleMemo singleTele = new TeleMemo();

    private TeleMemo() {
        //实例化
        this.perList = new ArrayList<Person>();
        //读取数据
        this.perList.addAll(ServiceFactory.getTeacherService().readPerson());
        this.perList.addAll(ServiceFactory.getFriendService().readPerson());
        this.perList.addAll(ServiceFactory.getKinsfolkService().readPerson());

        //按电话号码从小到大排序
        Collections.sort(this.perList,new SortPersonByPhone());

    }

    public ArrayList<Person> getPerList() {
        return perList;
    }

    public static TeleMemo getInstance() {
        return singleTele;
    }

    public void addPerson(Person per) {
        this.perList.add(per);
    }

    public boolean delPersonByPhone(String pid) {
        for( int i=0; i<perList.size(); i++ ) {
            if( perList.get(i).getPhone().equals(pid)) {
                perList.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
         new TeleIndexFrame();
    }





}
