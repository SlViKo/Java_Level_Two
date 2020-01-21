package ru.gb.jtwo.lone.online.lessontwo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class LineWork {
    private String line;
    private int[][] arrInt;
    private String[][] arrString;

    public LineWork(String line) {
        this.line = line;
    }

    public LineWork(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                line += (char) ch;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public String[][] changeStringToArray() {

        String[] arrOne = line.split("\n");
        arrString = new String[arrOne.length][arrOne.length];
        for (int i = 0; i < arrOne.length; i++) {
            arrString[i] = arrOne[i].split(" "); ;
        }
        return arrString;
    }

    public int[][] changeStringToInt() {
        if(arrString == null) {
            this.changeStringToArray();
        }
        arrInt = new int[arrString.length][arrString.length];
        for (int i = 0; i < arrString.length; i++) {
            for (int j = 0; j < arrString.length; j++) {
                arrInt[i][j] = Integer.parseInt(arrString[i][j]);
            }
        }
        return arrInt;
    }

    public int getSumDivideTwo() {
        int sum=0;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[i].length; j++) {
                sum += arrInt[i][j];
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrString);
    }
}
