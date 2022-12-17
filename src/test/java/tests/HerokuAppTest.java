package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get(ReadProperties.getUrl());
        actions
                .contextClick(waitsService.waitForVisibilityBy(By.id("hot-spot")))
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }

    @Test
    public void dynamicControlsTest() {
        driver.get(ReadProperties.getUrl1());
        WebElement checkBox = waitsService.waitForVisibilityBy(By.cssSelector("input[type='checkbox']"));
        actions
                .click(waitsService.waitForVisibilityBy(By.xpath("//button[text()='Remove']")))
                .build()
                .perform();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's gone!");
        Assert.assertTrue(waitsService.waitForElementInvisible(checkBox));

        WebElement input = waitsService.waitForVisibilityBy(By.cssSelector("[type='text']"));
        Assert.assertFalse(input.isEnabled());
        actions
                .click(waitsService.waitForVisibilityBy(By.cssSelector("[onclick='swapInput()']")))
                .build()
                .perform();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(input.isEnabled());
    }

    @Test
    public void fileUploadTest() {
        driver.get(ReadProperties.getUrl2());
        WebElement fileUploadPath = waitsService.waitForExists(By.id("file-upload"));
        String pathToFile = HerokuAppTest.class.getClassLoader().getResource("upload.jpeg").getPath()
                .substring(1);
        fileUploadPath.sendKeys(pathToFile);
        waitsService.waitForExists(By.id("file-submit")).submit();
        Assert.assertEquals(waitsService.waitForExists(By.id("uploaded-files")).getText(), "upload.jpeg");
    }

    @Test
    public void frameTest() {
        driver.get(ReadProperties.getUrl3());
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.cssSelector("p")).getText(), "Your content goes here.");
    }
}