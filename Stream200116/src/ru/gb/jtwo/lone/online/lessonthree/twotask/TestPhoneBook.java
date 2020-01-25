package ru.gb.jtwo.lone.online.lessonthree;

public class TestPhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson("Киркоров", "kir@adf.ru", "+79862561215");
        phoneBook.addPerson("Пугачева", "pug@dsss.ru", "+79875961111");
        phoneBook.addPerson("Галкин", "gal@dfaa.ru", "+79763632215");
        phoneBook.addPerson("Орбакайте", "or@ddf.ru", "+71596362212 ");
        phoneBook.addPerson("Бузова", "buz@cv.ru", "+79436952211 ");

        phoneBook.addPerson("Киркоров", "fff@adf.ru", "+78552559596");
        phoneBook.addPerson("Пугачева", "dddd@dsss.ru", "+79862512236");
        phoneBook.addPerson("Галкин", "dddd@dfaa.ru", "+79513692211");

        phoneBook.addPerson("Киркоров", "cccc@adf.ru", "+79784541010");
        phoneBook.addPerson("Пугачева", "xxxx@dsss.ru", "+79866962020");
        phoneBook.addPerson("Галкин", "zzzz@dfaa.ru", "+79633331010");

        System.out.print("Телефоны Киркорова: ");
        System.out.println(phoneBook.getPhoneByLastName("Киркоров"));

        System.out.print("Email Галкина: ");
        System.out.println(phoneBook.getEmailByLastName("Галкин"));



    }




}
