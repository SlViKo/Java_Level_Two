/**
 * Класс для рассчета значений в массиве с использованием многопоточности и без
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 31/01/2010
 */
package ru.gb.jtwo.lone.online.lessonfive;

import java.util.Arrays;

public class ArrTask {
    static final int SIZE = 10;
    static final int partOne = (int) Math.floor(SIZE / 2);
    static final int partTwo = (int) Math.ceil(SIZE / 2);

    public void calculationWithoutThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время затраченное на расчет массива, без использования многопоточности: " + (float) (System.currentTimeMillis() - timeStart) / 1000f + " сек");
    }

    public void calculationWithThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long timeStart = System.currentTimeMillis();
        float[] arrPartOne = arrDeleteTwo(arr, partOne);
        float[] arrPartTwo = arrDeleteTwo(arr, partTwo);

        WorkWithArrThread tOne = new WorkWithArrThread(arrPartOne, SIZE, "one");
        WorkWithArrThread tTwo = new WorkWithArrThread(arrPartTwo, SIZE, "two");

        tOne.run();
        tTwo.run();

        try {
            tOne.join();
            tTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrPartOne, 0, arr, 0, partOne);
        System.arraycopy(arrPartTwo, 0, arr, partOne, partTwo);

        System.out.println("Время затраченное на расчет массива, c использования многопоточности: " + (float) (System.currentTimeMillis() - timeStart) / 1000f + " сек");

    }

    private float[] arrDeleteTwo(float arr[], int part) {
        float[] arrPart;

        if (part == partOne) {
            arrPart = new float[partOne];
            System.arraycopy(arr, 0, arrPart, 0, partOne);
        } else {
            arrPart = new float[partTwo];
            System.arraycopy(arr, partOne, arrPart, 0, partTwo);
        }
        return arrPart;
    }
}
