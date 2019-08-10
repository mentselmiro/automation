package pages;

import static config.ApplicationConfig.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static final String USER_LOGIN_EMAIL_PATH = "user_login_email";
    private static final String USER_LOGIN_PASSWORD_PATH = "user_login_password";
    private static final String LOGIN_BUTTON_PATH = "commit";

    public WebElement getEmailField() {
        return driver.findElement(By.id(USER_LOGIN_EMAIL_PATH));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id(USER_LOGIN_PASSWORD_PATH));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.name(LOGIN_BUTTON_PATH));
    }


    public void login(String email,String password){
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

}


