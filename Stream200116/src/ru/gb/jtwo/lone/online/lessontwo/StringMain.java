/**
 * 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 * 10 3 1 2
 * 2 3 2 2
 * 5 6 7 1
 * 300 3 1 0
 * Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 * 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 * 3. Ваши методы должны бросить исключения в случаях:
 * Если размер матрицы, полученной из строки, не равен 4x4;
 * Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 * 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 * 5. * Написать собственные классы исключений для каждого из случаев
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 22/01/2020
 */

package ru.gb.jtwo.lone.online.lessontwo;

import java.io.File;

public class StringMain {
    public static void main(String[] args) throws ArrayFourException {

        String[][] arrayString;
        int[][] arrayInt;
        int sum;

        String string = "10 3 1 4\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        LineWork lineWork = new LineWork(string);
        arrayString = lineWork.changeStringToArray();
        printArray(arrayString);
        arrayInt = lineWork.changeStringToInt();
        printArray(arrayInt);
        sum = lineWork.getSumDivideTwo();
        System.out.println("Cумма чисел равна:" + sum);

        // исключение не на число
//        string = "10 у 1 4\n2 3 2 2\n5 6 7 1\n300 3 1 0";
//        lineWork = new LineWork(string);
//        arrayString = lineWork.changeStringToArray();
//        arrayInt = lineWork.changeStringToInt();
//        sum = lineWork.getSumDivideTwo();

        //исключение массив не 4 на 4
//        string = "10 1 1 4\n2 3 2 2\n5 6 7 1\n300 3 1 0\n22 4 4 4";
//        lineWork = new LineWork(string);
//        arrayString = lineWork.changeStringToArray();
//        arrayInt = lineWork.changeStringToInt();
//        sum = lineWork.getSumDivideTwo();

        //исключение массив не 4 на 4
//        string = "10 1 1 4\n2 3 2 2\n5 6 7 1\n300 3 1 0 5 5\";
//        lineWork = new LineWork(string);
//        arrayString = lineWork.changeStringToArray();
//        arrayInt = lineWork.changeStringToInt();
//        sum = lineWork.getSumDivideTwo();


        LineWork lineWorkFile = new LineWork(new File(System.getProperty("user.dir"), "example.txt"));

    }

    private static void printArray(String[][] arr) {
        System.out.println("Массив из String:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[][] arr) {
        System.out.println("Массив из int:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
