package ru.gb.jtwo.lone.online.lessonfive;

public class WorkWithArr extends Thread {

    private float[] arr;



    @Override
    public void run() {

    }

    public WorkWithArr(float[] arr) {
        this.arr = arr;
    }



    public void calculationWithoutThread() {

    }


    public float[] calculationWithThread(float[] arrPart) {
        for (int i = 0; i < arrPart.length; i++) {
            arrPart[i] = (float) (arrPart[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arrPart;
    }


}
