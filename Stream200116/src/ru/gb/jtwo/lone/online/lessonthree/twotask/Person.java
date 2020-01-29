package ru.gb.jtwo.lone.online.lessonthree.twotask;

import java.util.ArrayList;

public class Person {
    private String lastName;
    private ArrayList<String> listEmail = new ArrayList<String>();
    private ArrayList<String> listPhone =  new ArrayList<String>();

    public Person(String lastName, String email, String phone) {
        this.lastName = lastName;
        listEmail.add(email);
        listPhone.add(phone);
    }

    public void setEmail(String email) {
        listEmail.add(email);
    }

    public void setPhone(String phone) {
        listPhone.add(phone);
    }

    public ArrayList<String> getListEmail() {
        return listEmail;
    }

    public ArrayList<String> getListPhone() {
        return listPhone;
    }


}
