package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement uiElement;
    private WebDriver driver;
    private List<String> columns;

    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
        this.columns = new ArrayList<>();
        for (UIElement element : uiElement.findUIElements(By.tagName("th"))) {
            columns.add(element.getText());
        }
    }

    public List<String> getColumns() {
        return columns;
    }

    public UIElement getCell(int column, int rowIndex) {
        return null;

    }

    public UIElement getCell(String targetColumn, String targetValue, String columnValue) {
        return null;
    }

    public UIElement getCell(String targetColumn, String targetValue, int columnIndex) {
        return null;
    }
}
