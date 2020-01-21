package ru.gb.jtwo.lone.online.lessontwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LineWork {
    private String line;

    public LineWork(String line) {
        this.line = line;
    }

    public LineWork(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while((ch = fileInputStream.read()) != -1) {
                line += (char)ch;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public int[][] getIntArray() {
        
    }

    @Override
    public String toString() {
        return line;
    }
}
