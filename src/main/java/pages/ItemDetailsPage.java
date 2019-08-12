package pages;

import org.openqa.selenium.By;


import java.util.Locale;

import static config.ApplicationConfig.driver;

public class ItemDetailsPage {

    String TYPE_XPATH = "//div[contains(@class,'receipt_type_id')]//span";
    String DATE_XPATH = "//div[contains(@class,'receipt_date')]//div[contains(@class,'datepicker')]//input[@type = 'text']";
    String DUE_DATE_XPATH ="//div[@class='right-column'][1]//div[@class='element-wrapper']//input[@type = 'text']";
    String INVOICE_NUMBER_XPATH = "//input[@id='receipt_invoice_number']";
    String SUPPLIER_NAME_XPATH = "//div[@class='input supplier_shop optional receipt_shop_name']//input";
    String CATEGORY_NAME_XPATH = "//select[@id='receipt_category_id']";
        //"("#receipt_category_id option:selected").text()";
    //"//div[contains(@class,'receipt_category_id')]//option";



    public String getItemType() {
        return driver.findElement(By.xpath(TYPE_XPATH)).getText();

    }
    public String getItemDate(){
        return driver.findElement(By.xpath(DATE_XPATH)).getAttribute("value");
    }
    public String getItemDueDate(){
        return driver.findElement(By.xpath(DUE_DATE_XPATH)).getAttribute("value");
    }
    public String getInvoiceNumber(){
        return  driver.findElement(By.xpath(INVOICE_NUMBER_XPATH)).getAttribute("value");
    }
    public String getSupplierName(){
        return driver.findElement(By.xpath(SUPPLIER_NAME_XPATH)).getAttribute("value");
    }
    public String getCategoryName(){
        return driver.findElement(By.xpath(CATEGORY_NAME_XPATH)).getText();
    }
}
