package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> uiElementList;
    private List<String> valueList;
    private List<String> textList;

    // Продумать механизм поиска этого элемента
    // поиск по name
    public RadioButton(WebDriver driver, String attributeNameValue) {
        uiElementList = new ArrayList<>();
        valueList = new ArrayList<>();
        textList = new ArrayList<>();

        for (WebElement webElement : driver.findElements(By.name(attributeNameValue))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
            valueList.add(element.getAttribute("value"));
            textList.add(element.findUIElement(By.xpath("parent::*/strong")).getText().trim());
        }
    }

    // Добавить методы для работы с ним
    // selectByValue
    // selectByText
    // selectByIndex
    public void selectByIndex(int index) {
        uiElementList.get(index).click();
    }

    public void selectByValue(String value) {
        uiElementList.get(valueList.indexOf(value)).click();
    }

    public void selectByText(String text) {
        uiElementList.get(textList.indexOf(text)).click();
    }


    // Проверит что поиск и методы работают на всех похожих элемнетах сайта
}
