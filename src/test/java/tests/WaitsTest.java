package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class WaitsTest extends BaseTest {

    @Test
    public void implicitlyVisibilityTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Assert.assertFalse(button.isDisplayed());

        WebElement loading = driver.findElement(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Thread.sleep(10000);
        Assert.assertFalse(loading.isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector("#finish h4")).isDisplayed());
    }

    @Test
    public void explicitlyVisibilityTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WaitsService waitsService = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement button = waitsService.waitForVisibilityBy(By.tagName("button"));
        button.click();
        Assert.assertTrue(waitsService.waitForElementInvisible(button));

        WebElement loading = waitsService.waitForVisibilityBy(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(waitsService.waitForElementInvisible(loading));

        Assert.assertTrue(waitsService.waitForVisibilityBy(By.cssSelector("#finish h4")).isDisplayed());
    }
}
