package tests;

import config.ApplicationConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.DashboardPage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {
    @BeforeAll
    public static void beforeClass(){
        ApplicationConfig.invokeBrowser();

        try {
            login();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterAll
    public static void afterClass(){
        System.out.println("Kill BROWSER");
        ApplicationConfig.killBrowser();
    }

    public static void login() throws InterruptedException {
        LoginPage loginPage  = new LoginPage();
        loginPage.login("miroslav.mentsel+autorun@receipt-bank.com","SweetDreams");
        Thread.sleep(300);
        DashboardPage dashboardPage = new DashboardPage();
        assertEquals("Account Settings", dashboardPage.getAccountSettingsLink().getText());
    }

}
