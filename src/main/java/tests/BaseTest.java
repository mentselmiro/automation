package tests;

import config.ApplicationConfig;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import pages.DashboardPage;
import pages.LoginPage;

import static config.ApplicationConfig.driver;

public class BaseTest {
    @BeforeClass
    public static void beforeClass(){
        ApplicationConfig.invokeBrowser();

        try {
            login();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterClass
    public static void afterClass(){
        ApplicationConfig.killBrowser();
    }

    public static void login() throws InterruptedException {
        LoginPage loginPage  = new LoginPage();
        loginPage.login("miroslav.mentsel+autorun@receipt-bank.com","SweetDreams");
        Thread.sleep(300);
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertEquals("Account Settings", dashboardPage.getAccountSettingsLink().getText());
    }

}
