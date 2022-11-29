package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {

    @Test
    public void testSum() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test(description = "Тест с описанием")
    public void testSum1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test(testName = "Тест с названием")
    public void testSum3() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test(timeOut = 1000)
    public void testSum4() throws InterruptedException {
        Thread.sleep(1001);
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000)
    public void testSum5() throws InterruptedException {
        Thread.sleep(500);
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testSum6() throws InterruptedException {
        Thread.sleep(500);
    }
}
