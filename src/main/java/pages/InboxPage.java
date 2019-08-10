package pages;

import org.openqa.selenium.By;

import static config.ApplicationConfig.driver;

public class InboxPage {
    String TABLE_XPATH = "//table[contains(@class,'receipts-table')]";

    String ANY_CHECKBOX_XPATH = "//tbody/tr[%d]/td[1]/span[contains(@class,'checkbox')]";

    String DOWNLOAD_DROPDOWN_XPATH = "//a[contains(text(), 'Download')]";

    String FIRST_ITEM_IN_INBOX_XPATH = "//tbody/tr[1]/td[@class='type']/a";

    String CSV_DOWNLOAD_XPATH = "//a[contains(text(), 'Export to CSV')]";

    public void clickCheckbox(int rowNumber){
        String realCheckboxXpath = String.format(ANY_CHECKBOX_XPATH, rowNumber);
        driver.findElement(By.xpath(realCheckboxXpath)).click();

    }
    public  void openDownloadDropdown(){
        driver.findElement(By.xpath(DOWNLOAD_DROPDOWN_XPATH)).click();
    }
    public  void clickExportCSV(){
        driver.findElement(By.xpath(CSV_DOWNLOAD_XPATH)).click();
    }
    public void openFirstItem(){
        driver.findElement(By.xpath(FIRST_ITEM_IN_INBOX_XPATH)).click();

    }

}
