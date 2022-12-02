package tests.data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataForSum")
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5},
        };
    }

    @DataProvider (name = "signTestIntDiv")
    public static Object[][] dataForIntDivTest() {
        return new Object[][] {
                {-32, -8, 4},
                {32, -8, -4},
                {-32, 8, -4},
        };
    }

    @DataProvider (name = "signTestDoubleDiv")
    public static Object[][] dataForDoubleDivTest() {
        return new Object[][] {
                {-32.0, -8.0, 4.0},
                {32.0, -8.0, -4.0},
                {-32.0, 8.0, -4.0},
        };
    }
}
