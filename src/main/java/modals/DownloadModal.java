package modals;

import org.openqa.selenium.By;

import static config.ApplicationConfig.driver;

public class DownloadModal {
    //String CSV_FORMATS_DROPDOWN_XPATH = "//a[@class='caret']";             # Download CSV Modal dropdown
    String GENERATE_BUTTON_NAME = "//input[@value='Generate']";

    public void clickGenerateButton() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath(GENERATE_BUTTON_NAME)).click();

    }

}
