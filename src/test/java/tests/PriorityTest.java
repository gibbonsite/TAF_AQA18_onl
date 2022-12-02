package tests;

import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {
    Calculator calculator = new Calculator();

    @Test
    public void stepb() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test (priority = 1)
    public void stepa() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test (priority = 2)
    public void stepd() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

    @Test (priority = 3)
    public void stepc() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }
}
