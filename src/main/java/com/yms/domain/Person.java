package com.yms.domain;

import java.io.Serializable;

/**这是一个Person类,相当于定义一个Person类的抽象类
 *
 * @author created by yangminsen on 2018/6/3
 *
 */
public class Person implements Serializable {

    private String phone;
    private String name;
    private String address;

    public Person(String phone, String name, String address) {
        this.phone = phone;
        this.name = name;
        this.address = address;
    }

    public Person() {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

