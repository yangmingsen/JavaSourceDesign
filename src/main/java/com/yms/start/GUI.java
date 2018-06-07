package com.yms.start;

import com.yms.domain.Person;
import com.yms.gui.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class GUI {

    private static final char A = 'A';
    private static final char B = 'B';
    private static final char C = 'C';
    private static String _t="\t\t\t\t\t\t\t\t\t\t\t\t";

    public static void welcomeTeleMemo(List<Person> pri) {
        System.out.println("\n");
        System.out.println(_t+"              Welcome to TeleMemo           ");
        System.out.println(_t+"--------------------------------------------");
        System.out.println(_t+"-----------|Search what you want|-----------");
        System.out.println(_t+"--------------------------------------------");
        System.out.println(_t+"       A.朋友        B.家人      C.老师      ");
        System.out.println(_t+"--------------------------------------------");
        for (Person per : pri) {
            System.out.println(_t+"\t"+per.getPhone()+"\t\t\t"+per.getName());
        }
        System.out.println(_t+"--------------------------------------------");

    }

    public static void searchRes() {

    }

    public static void main(String[] args) {
        new MainFrame();
    }


}
