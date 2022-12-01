package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {
    Calculator calculator = new Calculator();

    @Test (groups = "smoke")
    public void stepb() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }
    @Test(groups = "regression")
    public void stepa() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }
    @Test(groups = "regression")
    public void stepd() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }
    @Test(groups = {"smoke", "regression"})
    public void stepc() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма ...");
    }

}
