package com.yms.utils.sort;

import com.yms.domain.Person;

import java.util.Comparator;

public class SortPersonByPhone implements Comparator {
    public int compare(Object o1, Object o2) {
        Person s1 = (Person) o1;
        Person s2 = (Person) o2;

        if( s1.getPhone().compareTo(s2.getPhone()) > 0 ) {
            return 1;
        }
        return -1;
    }
}
