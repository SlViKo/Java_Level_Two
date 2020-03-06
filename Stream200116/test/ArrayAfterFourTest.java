
import JavaThreeLessonSix.ArrayAfterFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ArrayAfterFourTest {
        private  static ArrayAfterFour arrayAfterFour = null;

        private int[] arrayResult;
        private int[] arrayTest;

    public ArrayAfterFourTest(int[] arrayTest, int[] arrayResult) {
        this.arrayResult = arrayResult;
        this.arrayTest = arrayTest;
    }

    @Before
    public void init() {
        arrayAfterFour = new ArrayAfterFour();
    }


    @Parameters
    public static Collection testArray() {
        return Arrays.asList(new Object[][] {
                {new int[]{3,4,5,6,1,5,4,2,2}, new int[]{2,2}}, // обычная проверка
                {new int[]{3,1,5,6,1,5,1,2,2}, new int[]{0}}, // в массиве нет четверки
                {new int[]{1,1,4,6,1,5,2,2,2}, new int[]{6,1,5,2,2,2}}, // значения не совпдаают
                {new int[]{3,4}, new int[]{0}} // 4 послденияя
        });
    }

    /*
    Проверка на выброс исключения, если 4 послденяя или вообще нет 4
     */
    @Test(expected = RuntimeException.class)
    public void paramTestArrayException() {
        Assert.assertArrayEquals(arrayAfterFour.arrayNumbersAfterFour(arrayTest), arrayResult);
    }

    @Test
    public void paramTestArray() {
        Assert.assertArrayEquals(arrayAfterFour.arrayNumbersAfterFour(arrayTest), arrayResult);
    }
}
