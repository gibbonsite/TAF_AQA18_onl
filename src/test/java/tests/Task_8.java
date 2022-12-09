package tests;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @Test
    public void sauceTest() {
        driver.get(ReadProperties.getUrl());

        // поиск по id
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());

        // поиск по name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

        // поиск по className
        driver.findElement(By.className("shopping_cart_link")).click();

        // поиск по css-локатору вида .class
        WebElement nameOfItem = driver.findElement(By.cssSelector(".inventory_item_name"));
        Assert.assertEquals(nameOfItem.getText(), "Sauce Labs Fleece Jacket");

        // поиск по xpath-локатору (по атрибуту)
        WebElement price = driver.findElement(By.xpath("//*[@class='inventory_item_price']"));
        Assert.assertEquals(price.getText(), "$49.99");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
