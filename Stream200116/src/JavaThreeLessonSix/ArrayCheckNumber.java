/**
 *
 * Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * [ 1 1 1 4 4 1 4 4 ] -> true
 * [ 1 1 1 1 1 1 ] -> false
 * [ 4 4 4 4 ] -> false
 * [ 1 4 4 1 1 4 3 ] -> false
 *
 * @author SlViKo(Кобозев Вячеслав)
 * @version date 06/03/2020
 */
package JavaThreeLessonSix;

public class ArrayCheckNumber {

    private final int FOUR = 4;
    private final int ONE = 1;
    public boolean checkArray(int[] numbers) {
        boolean isCheck = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == ONE || numbers[i] == FOUR) {
                isCheck = true;
                break;
            }
         }
        return isCheck;
    }

}
