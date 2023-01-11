package pages.project.testcases;

import baseEntities.BasePage;
import elements.DropDownMenu;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestCasePage extends BasePage {
    private final By contentHeaderTitleElementLocator = By.className("content-header-title");

    private DropDownMenu dropDownMenu;

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return contentHeaderTitleElementLocator;
    }

    public DropDownMenu getType() {
        if (dropDownMenu == null) {
            dropDownMenu = new DropDownMenu(driver, "type_id_chzn");
        }
        return dropDownMenu;
    }
}
