
package com.yms.comm;

import com.yms.domain.Friend;
import com.yms.domain.Kinsfolk;
import com.yms.domain.Person;
import com.yms.domain.Teacher;
import com.yms.start.TeleMemo;

import java.util.ArrayList;
import java.util.Vector;


/**
 * 为表格提供数据工厂
 * @author created by yangmingsen on 2018/6/6
 */
public class VectorForPersonFactory {

    public static Vector<Vector<String>> getKinsfolkData() {

        ArrayList<Person> t = TeleMemo.getInstance().getPerList();

        Vector<Vector<String>> res = new Vector<Vector<String>>();
        for(int i=0; i<t.size(); i++ ) {

            if( t.get(i) instanceof Kinsfolk ) {
                Vector<String> t2 = new Vector<String>();
                Kinsfolk t3 = (Kinsfolk)t.get(i);

                t2.add(t3.getPhone());
                t2.add(t3.getName());
                t2.add(t3.getAddress());
                t2.add(t3.getCall());
                t2.add(t3.getProfession());
                t2.add(t3.getWeChat());

                res.add(t2);
            }

        }

        return res;
    }

    public static Vector<Vector<String>> getFriendData() {
        ArrayList<Person> t = TeleMemo.getInstance().getPerList();
        Vector<Vector<String>> res = new Vector<Vector<String>>();
        for(int i=0; i<t.size(); i++ ) {
            if(t.get(i) instanceof Friend) {
                Vector<String> t2 = new Vector<String>();
                Friend t3 = (Friend) t.get(i);

                t2.add(t3.getPhone());
                t2.add(t3.getName());
                t2.add(t3.getAddress());
                t2.add(t3.getEmail());
                t2.add(t3.getQq());
                t2.add(t3.getWeChat());

                res.add(t2);
            }

        }

        return res;
    }

    public static Vector<Vector<String>> getTeacherData() {
        ArrayList<Person> t = TeleMemo.getInstance().getPerList();
        Vector<Vector<String>> res = new Vector<Vector<String>>();
        for(int i=0; i<t.size(); i++ ) {
            if( t.get(i) instanceof Teacher) {
                Vector<String> t2 = new Vector<String>();
                Teacher t3 = (Teacher)t.get(i);

                t2.add(t3.getPhone());
                t2.add(t3.getName());
                t2.add(t3.getAddress());
                t2.add(t3.getCall());
                t2.add(t3.getTech());
                t2.add(t3.getWorkSchool());
                t2.add(t3.getEmail());

                res.add(t2);
            }

        }

        return res;
    }
}
