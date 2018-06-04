package com.yms.comm;

import com.yms.service.PersonService;
import com.yms.service.impl.FriendServiceImpl;
import com.yms.service.impl.KinsfolkServiceImpl;
import com.yms.service.impl.TeacherServiceImpl;


/**
 * 这是一个数据业务层工厂,可以根据所需得到相应的对象.
 *
 * @author created by yangingsen on 2018/6/3
 */
public class ServiceFactory {

    public static PersonService getFriendService() {
        return FriendServiceImpl.getInstance();
    }

    public static PersonService getKinsfolkService() {
        return KinsfolkServiceImpl.getInstance();
    }

    public static PersonService getTeacherService() {
        return TeacherServiceImpl.getInstance();
    }
}
