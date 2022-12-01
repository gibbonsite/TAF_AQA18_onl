package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    Calculator calculator = new Calculator();

    @Test
    public void stepb() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }
    @Test(dependsOnMethods = "stepb")
    public void stepa() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }
    @Test(dependsOnMethods = "stepa", alwaysRun = true)
    public void stepd() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }
    @Test(dependsOnMethods = {"stepd", "stepa"})
    public void stepc() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

}
