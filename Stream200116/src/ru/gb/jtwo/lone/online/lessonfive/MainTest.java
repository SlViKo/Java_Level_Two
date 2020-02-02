/**
 * Основной класс для теста
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 31/01/2010
 */
package ru.gb.jtwo.lone.online.lessonfive;

public class MainTest {

    public static void main(String[] args) {
        ArrTask arr = new ArrTask();
        arr.calculationWithoutThread();
        arr.calculationWithThread();
    }

}
