package ru.gb.jtwo.lone.online.lessonthree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, Person> listPerson = new HashMap<>();

    public void addPerson(String lastName, String email, String phone) {
        if(listPerson.containsKey(lastName)) {
            listPerson.get(lastName).setEmail(email);
            listPerson.get(lastName).setPhone(phone);
        } else {
            listPerson.put(lastName, new Person(lastName, email, phone));
        }

    }

    public ArrayList<String> getPhoneByLastName (String lastName) {
        ArrayList<String> listPhone = new ArrayList<>();
        listPhone.add("Фамилии" + lastName + "нет в справочнике");
        for (Map.Entry<String, Person> telephoneContact : listPerson.entrySet()) {
            if(telephoneContact.getKey().equals(lastName)) {
                 listPhone = telephoneContact.getValue().getListPhone();
            }
        }
        return listPhone;
    }

    public ArrayList<String> getEmailByLastName (String lastName) {
        ArrayList<String> listEmail = new ArrayList<>();
        listEmail.add("Фамилии" + lastName + "нет в справочнике");
        for (Map.Entry<String, Person> telephoneContact : listPerson.entrySet()) {
            if(telephoneContact.getKey().equals(lastName)) {
                listEmail = telephoneContact.getValue().getListEmail();
            }
        }
        return listEmail;
    }




}
