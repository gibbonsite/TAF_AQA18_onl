package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.Retry;

public class RetryDivTest extends BaseTest {
    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class, groups = "smoke")
    public void flakyTestDivInt() {
        if (attempt == 5) {
            Assert.assertEquals(calculator.div(32, 8), 4);
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }

}