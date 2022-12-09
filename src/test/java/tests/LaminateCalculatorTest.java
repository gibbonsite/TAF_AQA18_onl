package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaminateCalculatorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @Test
    public void calcRehauTest() {
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement methodOfInstalling = driver.findElement(By.id("laying_method_laminate"));
        Select methodOfInstallingSelect = new Select(methodOfInstalling);
        methodOfInstallingSelect.selectByValue("2");

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");

        WebElement laminatePanelLength = driver.findElement(By.id("ln_lam_id"));
        laminatePanelLength.clear();
        laminatePanelLength.sendKeys("2000");

        WebElement laminatePanelWidth = driver.findElement(By.id("wd_lam_id"));
        laminatePanelWidth.clear();
        laminatePanelWidth.sendKeys("200");

        WebElement laminateDirection1 = driver.findElement(By.id("direction-laminate-id1"));
        laminateDirection1.click();

        driver.findElement(By.linkText("Рассчитать")).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElement(By.xpath(
                "//div/div[contains(text(), 'Требуемое количество досок')]"))
                .getText(), "Требуемое количество досок ламината: 53");

        Assert.assertEquals(driver.findElement(By.xpath(
                "//div/div[contains(text(), 'Количество упаковок')]"))
                .getText(), "Количество упаковок ламината: 7");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
