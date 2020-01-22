/**
 * 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 *  10 3 1 2
 *  2 3 2 2
 *  5 6 7 1
 *  300 3 1 0
 *  Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 *  2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 *  3. Ваши методы должны бросить исключения в случаях:
 *     Если размер матрицы, полученной из строки, не равен 4x4;
 *     Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 *  4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 *  5. * Написать собственные классы исключений для каждого из случаев
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 22/01/2020
 */
package ru.gb.jtwo.lone.online.lessontwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    /**
     * Метод преобразования строки в массив строк
     * @return
     * @throws ArrayFourException
     */
    public String[][] changeStringToArray() throws ArrayFourException {
        String[] arrOne = line.split("\n");
        try {
            arrString = new String[arrOne.length][arrOne.length];
            if (arrString.length != 4) {
                throw new ArrayFourException();
            }
        } catch (ArrayFourException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < arrOne.length; i++) {
            try {
                arrString[i] = arrOne[i].split(" ");
                ;
                if (arrString[i].length != 4) {
                    throw new ArrayFourException();
                }
            } catch (ArrayFourException e) {
                throw new RuntimeException(e);
            }

        }
        return arrString;
    }

    /**
     * Метод преобразования массива строк в массив чисел
     * @return
     * @throws ArrayFourException
     */
    public int[][] changeStringToInt() throws ArrayFourException {
        if (arrString == null) {
            this.changeStringToArray();
        }
        arrInt = new int[arrString.length][arrString.length];
        for (int i = 0; i < arrString.length; i++) {
            for (int j = 0; j < arrString.length; j++) {
                try {
                    arrInt[i][j] = Integer.parseInt(arrString[i][j]);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e + "Ошибка: Невозможно преобразовать не число");
                }
                arrInt[i][j] = Integer.parseInt(arrString[i][j]);
            }
        }
        return arrInt;
    }

    /**
     * метод получения суммы из массива чисел
     * @return
     */
    public int getSumDivideTwo() {
        if(arrInt == null) {
            System.out.println("Преобразуйте строку в массив чисел, перед получением суммы");
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[i].length; j++) {
                sum += arrInt[i][j];
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return line;
    }
}
