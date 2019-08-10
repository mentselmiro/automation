package tests;

import com.opencsv.CSVReader;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import config.Settings;
import enums.csv.file.formats.ReceiptBankDefaultCSV;
import modals.DownloadModal;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.DownloadPage;
import pages.InboxPage;
import pages.ItemDetailsPage;


import java.io.File;
import java.io.FileReader;

import java.io.Reader;
import java.util.*;

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

        dashboardPage.clickInbox();
        inboxPage.clickCheckbox(1);
        inboxPage.openDownloadDropdown();
        inboxPage.clickExportCSV();

        DownloadModal downloadModal = new DownloadModal();
        downloadModal.clickGenerateButton();

        DownloadPage downloadPage = new DownloadPage();
        downloadPage.waitForPageLoading();
        WebElement downloadPageButton = downloadPage.getButton();
        Assert.assertTrue(downloadPageButton.isDisplayed());
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
                Assert.assertTrue(headers.contains(header.getName()));
            }

            Assert.assertEquals(expectedValues.get(ReceiptBankDefaultCSV.TYPE), list.get(1)[1]);
            Assert.assertEquals(expectedValues.get(ReceiptBankDefaultCSV.DATE), list.get(1)[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @AfterClass
    public static void after() {
        File file = new File(fullFileName);

        file.delete();
    }

}
