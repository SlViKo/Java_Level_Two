package ru.gb.jtwo.lone.online.lessontwo;

import java.io.File;

public class StringMain {
    public static void main(String[] args) {

        String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        System.out.println(string.split("\n").length);

        LineWork lineWork = new LineWork(string);

        int[][] arr = lineWork.changeStringToInt();
        String[][] strings = lineWork.changeStringToArray();
        int sum = lineWork.getSumDivideTwo();

        System.out.println(sum);
        System.out.println(arr);

        for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]+ " ");
                }
            System.out.println();
        }

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                System.out.print(strings[i][j] + " ");
            }
            System.out.println();
        }

        LineWork lineWorkFile = new LineWork(new File(System.getProperty("user.dir"),"example.txt"));

    }
}
