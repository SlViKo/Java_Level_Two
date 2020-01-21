package ru.gb.jtwo.lone.online.lessontwo;

import java.io.File;

public class StringMain {
    public static void main(String[] args) {

        String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        LineWork lineWork = new LineWork(string);

        LineWork lineWorkFile = new LineWork(new File(System.getProperty("user.dir"),"example.txt"));
    }
}
