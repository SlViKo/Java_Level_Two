package ru.gb.jtwo.lone.online.lessontwo;

public class ArrayFourException extends Exception {
    private String message = "Ошибка: Массив должен быть размерностью 4 на 4";

    public ArrayFourException() {

    }

    public ArrayFourException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return message;
    }
}
