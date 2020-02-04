/**
 * класс для расчета элементов массива в потоке
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 31/01/2010
 */
package ru.gb.jtwo.lone.online.lessonfive;

public class WorkWithArrThread extends Thread {

    private float[] arr;
    private final int SIZE;
    private final String PART;


    public WorkWithArrThread(float[] arr, int SIZE, String PART) {
        this.arr = arr;
        this.PART = PART;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        if (PART.equals("one")) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        } else if (PART.equals("two")) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + (int) Math.floor(SIZE / 2)) / 5) * Math.cos(0.2f + (i + (int) Math.floor(SIZE / 2)) / 5) * Math.cos(0.4f + (i + (int) Math.floor(SIZE / 2)) / 2));
            }
        }


    }


}
