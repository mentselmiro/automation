package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationConfig {



    public static WebDriver driver;


    public static void invokeBrowser() {

        try {

            System.setProperty(Settings.GECKO_DRIVER_KEY, Settings.GECKO_DRIVER_PATH);



            driver = new FirefoxDriver(createOptions());
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

            driver.get(Settings.STAGING_URL);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static FirefoxOptions createOptions(){

        //create auto-save csv options
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", Settings.DOWNLOAD_LOCATION);
        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
        return options;
    }


    public static void killBrowser() {
        driver.quit();
    }
}


