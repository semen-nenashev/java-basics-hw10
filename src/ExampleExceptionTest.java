import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {

    /**
     * Test data for positive test.
     *
     * @return test data array
     */
    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
                {2, 2, 4},
                {2, 3, 6},
                {4, 4, 16},
                {5, 2, 10}
        };
    }

    /**
     * Test data for exception test.
     *
     * @return test data array
     */
    @DataProvider(name = "negativeData")
    public static Object[][] negativeData() {
        return new Object[][]{
                {-2, 2},
                {2, -2},
                {-3, 5},
                {5, -7}
        };
    }

    @Test(dataProvider = "data")
    public void testRectangleArea(int a, int b, int c) {
        Assert.assertEquals(ExampleException.rectangleArea(a, b), c, "input value is below zero!");
    }


    @Test(dataProvider = "negativeData", expectedExceptions = IllegalArgumentException.class)
    public void testRectangleAreaNegative(int a, int b) {
    ExampleException.rectangleArea(a, b);

    }
}