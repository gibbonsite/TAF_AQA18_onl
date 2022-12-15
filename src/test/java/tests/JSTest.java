package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSTest extends BaseTest {

    @Test
    public void jsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");
        WebElement webElement = driver.findElement(By.id("ui-id-2"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", webElement);

        Thread.sleep(5000);


        String s = (String) javascriptExecutor.executeScript("return document.getElementsByName('txtSearchText')[0].value");

        WebElement w1 = driver.findElement(By.name("txtSearchText"));
        s = (String) javascriptExecutor.executeScript("return arguments[0].value", w1);
    }

    @Test
    public void actionTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        Thread.sleep(3000);

        DragAndDropJS(source, target, driver);

        Thread.sleep(3000);
    }


    public void DragAndDropJS(WebElement source, WebElement destination, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n"
                + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n"
                + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n"
                + "},\n" + "getData: function (key) {\n"
                + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n"
                + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n"
                + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n"
                + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n"
                + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", source, destination);
    }
}
