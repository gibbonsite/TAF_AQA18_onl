package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.project.AddProjectPage;
import steps.NavigationSteps;

public class CheckBoxTest extends BaseTest {
    @Test
    public void checkBoxTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        new NavigationSteps(driver).navigateToAddProjectPage();
        CheckBox checkBox = new CheckBox(driver, By.name("show_announcement"));

        checkBox.setFlag();
        checkBox.removeFlag();
        checkBox.isSelected();
    }
}
