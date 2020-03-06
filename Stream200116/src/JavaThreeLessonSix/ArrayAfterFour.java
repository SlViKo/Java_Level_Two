/**
 *
 * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
 * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 *
 * @author SlViKo(Кобозев Вячеслав)
 * @version date 06/02/2020
 */
package JavaThreeLessonSix;

public class ArrayAfterFour {

    private final int FOUR = 4;

    public int[] arrayNumbersAfterFour(int[] numbers) {
        int[] numbersAfterFour;
        int indexLastFour = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == FOUR) {
                indexLastFour = i;
            }
        }
        if(indexLastFour != -1 || indexLastFour != numbers.length-1) {
            numbersAfterFour = new int[numbers.length-indexLastFour-1];
            System.arraycopy(numbers, indexLastFour+1, numbersAfterFour, 0, numbers.length-indexLastFour-1);
        } else {
            throw new RuntimeException("В массиве 4 последняя в списке или массив не содержит 4");
        }
        return numbersAfterFour;
    }

}
