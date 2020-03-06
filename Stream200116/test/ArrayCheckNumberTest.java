import JavaThreeLessonSix.ArrayCheckNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;



@RunWith(value = Parameterized.class)
public class ArrayCheckNumberTest {

    ArrayCheckNumber arrayCheckNumber = null;

    private int[] arrayTest;
    private boolean checkArray;

    public ArrayCheckNumberTest(int[] arrayTest, boolean checkArray) {
        this.arrayTest = arrayTest;
        this.checkArray = checkArray;
    }

    @Before
    public void init() {
        arrayCheckNumber = new ArrayCheckNumber();
    }

    @Parameterized.Parameters
    public static Collection arrayCheckOneOrFour() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 6, 7, 8}, false},
                {new int[]{3, 1, 6, 99}, true},
                {new int[]{44, 4, 42, 1, 5}, true},
                {new int[]{1, 4}, true}
        });
    }

    @Test
    public void paramTestArrayCheckOneOrFour() {
        Assert.assertEquals(arrayCheckNumber.checkArray(arrayTest), checkArray);

    }
}
