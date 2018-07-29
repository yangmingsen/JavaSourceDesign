package com.yms.repository.impl;

import com.yms.domain.Kinsfolk;
import com.yms.domain.Person;
import com.yms.repository.PersonRepository;

import java.io.*;
import java.util.ArrayList;

/**
 * 亲人类数据仓库
 * created by yangmingsen on 2018/06/10
 */
public class PersonKinsfolkRepositoryImpl implements PersonRepository {

    public ArrayList<Person> readPerson() {

        File file = new File("E:\\JavaProject\\JCDDB\\kinsfolks.txt");
        if(!file.exists()) {
            System.out.println("File of kinsfolk.txt not exists!");
            return null;
        }
        ArrayList<Person> ar = new ArrayList<Person>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            while(true) {
                try {
                    Person tmp = (Person)ois.readObject();
                    ar.add(tmp);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }catch(EOFException e){
                    break;
                }catch(NullPointerException ee){
                    continue;
                }
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ar;
    }

    public void writePersion(ArrayList<Person> pers) {
        File file = new File("E:\\JavaProject\\JCDDB\\kinsfolks.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(file));
            //oos.writeObject(ar);
            for(int i=0; i<pers.size(); i++ ) {
                oos.writeObject((Kinsfolk)pers.get(i));
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Write Knisfolks.txt Ok!");
    }
}
