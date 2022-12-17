package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class DownloadFileTest extends BaseTest {
    private File downloadedFile;

    @Test
    public void downloadFileTest() {
        driver.get(ReadProperties.getUrl4());
        WebElement downloadLinkElement = waitsService.waitForVisibilityBy(By.linkText("sample.pdf"));
        downloadLinkElement.click();
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500));
        wait.until(driver -> isFilePresent());
    }

    @Test
    public boolean isFilePresent() {
        File folder = new File(System.getProperty("user.dir"));
        // List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        // Look for the file in the files
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.matches("sample.pdf")) {
                    downloadedFile = file;
                    found = true;
                }
            }
        }
        return found;
    }

    @AfterMethod
    public void removeDownloadedFile() {
        if (downloadedFile != null) {
            downloadedFile.delete();
        }
    }
}
