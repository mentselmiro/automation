package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static config.ApplicationConfig.driver;

public class DownloadPage {


    String DOWNLOAD_BUTTON_XPATH = "//a[contains(text(), 'Download')]";
    String FILE_NAME_XPATH = "//span[@class='filename']";


    String CONTENT_DIV = "receipt-export-content"; //това чака да се зареди страничката

    public void waitForPageLoading() {
        new WebDriverWait(driver, 3600)
                .until(ExpectedConditions.elementToBeClickable(By.className(CONTENT_DIV)));
    }

    public WebElement getButton() {
        WebElement downloadButton = new WebDriverWait(driver, 3600)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(DOWNLOAD_BUTTON_XPATH)));

        return downloadButton;
    }

    public String getFileName() {
        return driver.findElement(By.xpath(FILE_NAME_XPATH)).getText();
    }
}
