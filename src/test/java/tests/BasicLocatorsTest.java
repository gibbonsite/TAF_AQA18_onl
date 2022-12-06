package tests;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicLocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @Test
    public void basicLocatorsTest() {
        driver.get(ReadProperties.getUrl());

        // Find webElement by ID
        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());

        // Find webElement by Name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        driver.findElement(By.tagName("button")).click();

    }

    @Test
    public void basicLocatorsTest_2() throws InterruptedException {
        driver.get(ReadProperties.getUrl());

        // Find webElement by linkText
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(2000);

        // Find webElement by ClassName
        driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();

        Thread.sleep(2000);

        // Find webElement by PartialLinkText
        driver.findElement(By.partialLinkText("your password?")).click();

        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
