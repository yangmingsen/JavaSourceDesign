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


/***
 * 主程序,使用单利模式设计.
 * Created by yangmingsen on 2018/6/5
 */
public class TeleMemo {

    private ArrayList<Person> perList;
    private static final TeleMemo singleTele = new TeleMemo();

    //构造方法
    private TeleMemo() {
        this.initTeleData();
    }

    //程序开始
    public void initTeleData() {
        //实例化
        this.perList = new ArrayList<Person>();

        //读取数据
        if(ServiceFactory.getTeacherService().readPerson() != null) {
            this.perList.addAll(ServiceFactory.getTeacherService().readPerson());
        }
        if(ServiceFactory.getKinsfolkService().readPerson() != null) {
            this.perList.addAll(ServiceFactory.getKinsfolkService().readPerson());
        }
        if(ServiceFactory.getFriendService().readPerson() != null) {
            this.perList.addAll(ServiceFactory.getFriendService().readPerson());
        }

        for (Person per: this.perList) {
            System.out.println(per.toString());
        }

        //按电话号码从小到大排序
        Collections.sort(this.perList,new SortPersonByPhone());
    }

    /**
     * 查询所有联系人
     * @return ArrayList<Person>
     */
    public ArrayList<Person> getPerList() {
        return perList;
    }

    /**
     * 获得实例
     * @return 实例
     */
    public static TeleMemo getInstance() {
        return singleTele;
    }

    /**
     * 增加一个联系人
     * @param per
     */
    public void addPerson(Person per) {
        this.perList.add(per);
    }

    /**
     * 根据pid进行删除联系人
     * @param pid
     * @return
     */
    public boolean delPersonByPhone(String pid) {
        for( int i=0; i<perList.size(); i++ ) {
            if( perList.get(i).getPhone().equals(pid)) {
                perList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
         new TeleIndexFrame();
    }

    public void sayHello() {
        System.out.println("hello  world");
    }





}
