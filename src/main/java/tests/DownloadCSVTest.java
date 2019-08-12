package tests;

import com.opencsv.CSVReader;
import config.Settings;
import enums.csv.file.formats.ReceiptBankDefaultCSV;
import modals.DownloadModal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.DownloadPage;
import pages.InboxPage;
import pages.ItemDetailsPage;


import java.io.File;
import java.io.FileReader;

import java.io.Reader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadCSVTest extends BaseTest {

    static String fullFileName;

    @Test
    public void shouldDownloadCSV() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickInbox();

        InboxPage inboxPage = new InboxPage();
        inboxPage.openFirstItem();

        ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
        Map<ReceiptBankDefaultCSV, String> expectedValues = new HashMap();
        expectedValues.put(ReceiptBankDefaultCSV.TYPE, itemDetailsPage.getItemType());
        expectedValues.put(ReceiptBankDefaultCSV.DATE, itemDetailsPage.getItemDate());
        expectedValues.put(ReceiptBankDefaultCSV.DUE_DATE, itemDetailsPage.getItemDueDate());
        expectedValues.put(ReceiptBankDefaultCSV.INVOICE_NUMBER, itemDetailsPage.getInvoiceNumber());
        expectedValues.put(ReceiptBankDefaultCSV.SUPPLIER, itemDetailsPage.getSupplierName());
        expectedValues.put(ReceiptBankDefaultCSV.CATEGORY, itemDetailsPage.getCategoryName());


        dashboardPage.clickInbox();
        inboxPage.clickCheckbox(1);
        inboxPage.openDownloadDropdown();
        inboxPage.clickExportCSV();

        DownloadModal downloadModal = new DownloadModal();
        downloadModal.clickGenerateButton();

        DownloadPage downloadPage = new DownloadPage();
        downloadPage.waitForPageLoading();
        WebElement downloadPageButton = downloadPage.getButton();
        assertTrue(downloadPageButton.isDisplayed());
        String fileName = downloadPage.getFileName();
        downloadPageButton.click();

        verifyCSVFields(fileName, expectedValues);
    }

    public void verifyCSVFields(String fileName, Map<ReceiptBankDefaultCSV, String> expectedValues) {
        fullFileName = Settings.DOWNLOAD_LOCATION + '/' + fileName;

        try {
            Reader fileReader = new FileReader(fullFileName);
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> list = csvReader.readAll();
            csvReader.close();
            for (String[] l : list) {
                for (String s : l) {
                    System.out.println(s.toUpperCase() + "(\"" + s + "\"),");
                }
                System.out.println();
            }
            List<String> headers = Arrays.asList(list.get(0));
            for (ReceiptBankDefaultCSV header : ReceiptBankDefaultCSV.values()) {
                assertTrue(headers.contains(header.getName()));
            }

            assertEquals(expectedValues.get(ReceiptBankDefaultCSV.TYPE), list.get(1)[1]);
            assertEquals(expectedValues.get(ReceiptBankDefaultCSV.DATE), list.get(1)[2]);
            assertEquals(expectedValues.get(ReceiptBankDefaultCSV.DUE_DATE), list.get(1)[3]);
            assertEquals(expectedValues.get(ReceiptBankDefaultCSV.INVOICE_NUMBER), list.get(1)[4]);
            assertEquals(expectedValues.get(ReceiptBankDefaultCSV.SUPPLIER), list.get(1)[5]);
            assertEquals(expectedValues.get(ReceiptBankDefaultCSV.CATEGORY), list.get(1)[6]);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @AfterEach
    public void after() {
        File file = new File(fullFileName);
        System.out.println("File Deletion");

        file.delete();
    }

}
