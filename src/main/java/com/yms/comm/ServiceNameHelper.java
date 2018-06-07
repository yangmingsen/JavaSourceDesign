package com.yms.comm;

import java.util.Vector;

/**
 * 为表格提供数据标题工厂
 * @author created by yangmingsen on 2018/6/5
 */
public class ServiceNameHelper {

    public static Vector<String> getKinsfolkName() {
        Vector<String> res = new Vector<String>();
        res.add("电话");
        res.add("名字");
        res.add("地址");
        res.add("称呼");
        res.add("职业");
        res.add("微信");

        return res;
    }

    public static Vector<String> getFriendName() {
        Vector<String> res = new Vector<String>();
        res.add("电话");
        res.add("名字");
        res.add("地址");
        res.add("E-Mail");
        res.add("qq");
        res.add("微信");

        return res;
    }

    public static Vector<String> getTeacherName() {
        Vector<String> res = new Vector<String>();
        res.add("电话");
        res.add("名字");
        res.add("地址");
        res.add("称呼");
        res.add("教授");
        res.add("学校");
        res.add("E-Mail");

        return res;
    }
}
