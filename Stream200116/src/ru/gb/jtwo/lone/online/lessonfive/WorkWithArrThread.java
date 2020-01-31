/**
 * класс для расчета элементов массива в потоке
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 31/01/2010
 */
package ru.gb.jtwo.lone.online.lessonfive;

public class WorkWithArrThread extends Thread {

    private float[] arr;

    public WorkWithArrThread(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


}
