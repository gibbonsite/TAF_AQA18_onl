package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

public class DivTest extends BaseTest {

    @Test(enabled = false)
    public void divIntTest1() {
        Assert.assertEquals(calculator.div(30, 2), 15, "Incorrect division...");
    }

    @Test(enabled = false)
    public void divDoubleTest1() {
        Assert.assertEquals(calculator.div(30.0, 2.0), 15.0, "Incorrect division...");
    }

    @Test(groups = "smoke", priority = 1)
    public void divIntTest() {
        Assert.assertEquals(calculator.div(28, 4), 7, "Incorrect division...");
    }

    @Test(groups = "regression", priority = 2)
    public void divDoubleTest() {
        Assert.assertEquals(calculator.div(28.0, 4.0), 7.0, "Incorrect division...");
    }

    @Test(invocationCount = 5, invocationTimeOut = 1000, threadPoolSize = 5, groups = "smoke")
    public void divIntInvocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(28, 4), 7, "Incorrect division...");
    }

    @Test(invocationCount = 2, invocationTimeOut = 1000, threadPoolSize = 2, groups = "smoke")
    public void divDoubleInvocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(28.0, 4.0), 7.0, "Incorrect division...");
    }

    @Test(timeOut = 1000, groups = "regression")
    public void divIntTimeOutTest() throws InterruptedException {
        Thread.sleep(900);
        Assert.assertEquals(calculator.div(28, 4), 7, "Incorrect division...");
    }

    @Test(timeOut = 1000, groups = "regression")
    public void divDoubleTimeOutTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(28.0, 4.0), 7.0, "Incorrect division...");
    }

    @Test(dataProvider = "signTestIntDiv", dataProviderClass = StaticProvider.class, groups = "smoke")
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Incorrect division...");
    }

    @Test(dataProvider = "signTestDoubleDiv", dataProviderClass = StaticProvider.class, groups = "smoke")
    public void testDataProvider(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Incorrect division...");
    }

    @Test(groups = "smoke")
    public void testDiv0byInt(){
        Assert.assertEquals(calculator.div(0, 28), 0);
    }

    @Test(groups = "smoke")
    public void testDiv0byNegInt(){
        Assert.assertEquals(calculator.div(0, -28), 0);
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke")
    public void testExceptionsIntBy0(){
        Assert.assertEquals(calculator.div(28, 0),0, "Division by zero is not allowed");
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke")
    public void testExceptionsNegIntBy0(){
        Assert.assertEquals(calculator.div(-28, 0),0, "Division by zero is not allowed");
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke")
    public void testExceptionsInt0by0(){
        Assert.assertEquals(calculator.div(0, 0), 0, "Division by zero is not allowed");
    }

    @Test(groups = "smoke")
    public void testDiv0byDouble(){
        Assert.assertEquals(calculator.div(0, 28.0), 0);
    }

    @Test(groups = "smoke")
    public void testDiv0byNegDouble(){
        Assert.assertEquals(calculator.div(0, -28.0), 0);
    }

    @Test(groups = "smoke")
    public void testDouble0by0() throws ArithmeticException {
        Assert.assertEquals(calculator.div(0.0, 0.0), Double.NaN);
    }

    @Test(groups = "smoke")
    public void testDoubleBy0() throws ArithmeticException {
        Assert.assertEquals(calculator.div(28.0, 0.0), Double.POSITIVE_INFINITY);
    }

    @Test(groups = "smoke")
    public void testNegDoubleBy0() throws ArithmeticException {
        Assert.assertEquals(calculator.div(-28.0, 0.0), Double.NEGATIVE_INFINITY);
    }
}