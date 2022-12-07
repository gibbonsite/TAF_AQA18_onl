package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalcRehauTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @Test
    public void calcRehauTest() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement floorWidth = driver.findElement(By.id("el_f_width"));
        floorWidth.sendKeys("3");

        WebElement floorLength = driver.findElement(By.id("el_f_lenght"));
        floorLength.sendKeys("5");

        WebElement roomType = driver.findElement(By.id("room_type"));
        Select roomTypeSelect = new Select(roomType);
        roomTypeSelect.selectByVisibleText("Кухня или спальня");

        WebElement heatingType = driver.findElement(By.id("heating_type"));
        Select heatingTypeSelect = new Select(heatingType);
        heatingTypeSelect.selectByVisibleText("Основное отопление");

        WebElement heatLosses = driver.findElement(By.id("el_f_losses"));
        heatLosses.sendKeys("8603");

        WebElement calcButton = driver.findElement(By.name("button"));
        calcButton.click();

        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"),
                "9033");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"),
                "602");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
