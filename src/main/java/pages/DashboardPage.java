package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static config.ApplicationConfig.driver;

public class DashboardPage {

    String ACCOUNT_SETTINGS_XPATH = "//a[contains(text(),'Account Settings')]";
    String INBOX_LINK_XPATH = "//a[contains(text(), 'Inbox')]";

    public WebElement getAccountSettingsLink() {

        return driver.findElement(By.xpath(ACCOUNT_SETTINGS_XPATH));

    }

    public void clickInbox() {
        driver.findElement(By.xpath(INBOX_LINK_XPATH)).click();

    }

}
