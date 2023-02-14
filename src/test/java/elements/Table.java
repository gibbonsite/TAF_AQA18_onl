package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement uiElement;
    private WebDriver driver;
    private List<String> columns;

    /**
     * Данный элемент идентифицируертся по тэгу table
     * @param driver
     * @param by
     */
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

    public UIElement getCell(int columnIndex, int rowIndex) {
        return null;
    }

    public UIElement getCell(String targetColumn, String targetValue, String columnName) {
        return null;
    }

    public UIElement getCell(String targetColumn, String targetValue, int columnIndex) {
        return null;
    }

    public TableRow getRow(int i) {
        ArrayList<UIElement> list = (ArrayList<UIElement>) uiElement.findUIElements(By.tagName("tr"));
        return new TableRow(driver, list.get(i));
    }

}
