package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

public class DataProviderTest {

    Calculator calculator = new Calculator();

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Неверная сумма ...");
    }
}
