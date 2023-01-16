package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement uiElement;
    private UIElement searchElement;
    private UIElement dropMenuElement;
    private List<UIElement> menuElementList;
    private List<String> menuList;
    private WaitsService waitsService;

    public DropDownMenu(WebDriver driver, String parentElementId) {
        UIElement dropDownMenuContainerElement = new UIElement(driver, By.id(parentElementId));
        uiElement = dropDownMenuContainerElement.findUIElement(By.tagName("a"));
        dropMenuElement = dropDownMenuContainerElement.findUIElement(By.className("chzn-results"));
        searchElement = dropDownMenuContainerElement.findUIElement(By.tagName("input"));
        waitsService = new WaitsService(driver);

        menuElementList = new ArrayList<>();
        menuList = new ArrayList<>();
        for (UIElement element : dropMenuElement.findUIElements(By.tagName("li"))) {
            menuElementList.add(element);
            menuList.add(element.getAttribute("innerText"));
        }
    }

    public void showMenu() {
        if (!dropMenuElement.isDisplayed()) {
            uiElement.click();
            waitsService.waitForElementVisible(dropMenuElement);
        }
    }

    public void search(String searchText) {
        showMenu();
        searchElement.sendKeys(searchText);
    }

    public void selectByText(String text) {
        showMenu();
        menuElementList.get(menuList.indexOf(text)).click();
    }
}
