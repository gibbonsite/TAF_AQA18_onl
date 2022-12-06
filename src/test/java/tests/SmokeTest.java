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

public class SmokeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }
    @Test
    public void validateIKTCalculator() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement heightInput = driver.findElement(By.name("height"));
        WebElement weightInput = driver.findElement(By.name("weight"));
        WebElement calcButton = driver.findElement(By.id("calc-mass-c"));
        heightInput.sendKeys("183");
        weightInput.sendKeys("58");
        calcButton.click();
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKFTest() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
//        selectSex.selectByIndex(1);
//        Thread.sleep(2000);
//        selectSex.selectByValue("0");
//        Thread.sleep(2000);
        selectSex.selectByVisibleText("женский");

        driver.findElement(By.id("oCr")).sendKeys("80");
        driver.findElement(By.id("oAge")).sendKeys("38");
        driver.findElement(By.id("oWeight")).sendKeys("55");
        driver.findElement(By.id("oHeight")).sendKeys("163");
        driver.findElement(By.cssSelector("[type='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtMDRD")).getText(),
                "MDRD: 74 (мл/мин/1,73кв.м)");
        Assert.assertEquals(driver.findElement(By.id("txtMDRD1")).getText(),
                "ХБП: 2 стадия (при наличии почечного повреждения)");
        Assert.assertEquals(driver.findElement(By.id("txtCG")).getText(),
                "Cockroft-Gault: 70 (мл/мин)");
        Assert.assertEquals(driver.findElement(By.id("txtBSA")).getText(),
                "Поверхность тела:1.58 (кв.м)");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
