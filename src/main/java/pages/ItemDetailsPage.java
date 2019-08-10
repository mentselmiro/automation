package pages;

import org.openqa.selenium.By;

import java.util.Date;

import static config.ApplicationConfig.driver;

public class ItemDetailsPage {

    String TYPE_XPATH = "//div[contains(@class,'receipt_type_id')]//span";
    String DATE_XPATH = "//div[contains(@class,'receipt_date')]//div[contains(@class,'datepicker')]//input[@type = 'text']";


   // String DUE_DATE_XPATH =      ""
    //String


    public String getItemType() {
        return driver.findElement(By.xpath(TYPE_XPATH)).getText();

    }
    public String getItemDate(){
        return driver.findElement(By.xpath(DATE_XPATH)).getAttribute("value");
    }

}
