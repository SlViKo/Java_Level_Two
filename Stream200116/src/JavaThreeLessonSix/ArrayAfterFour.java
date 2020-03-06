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
        if(indexLastFour != -1 && indexLastFour != numbers.length-1) {
            numbersAfterFour = new int[numbers.length-indexLastFour-1];
            System.arraycopy(numbers, indexLastFour+1, numbersAfterFour, 0, numbers.length-indexLastFour-1);
        } else {
            throw new RuntimeException("В массиве 4 последняя в списке или массив не содержит 4");
        }
        return numbersAfterFour;
    }

}
