package PageFactory;

import Base.BasePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePageObjects {
    public Login(WebDriver driver) {
        super(driver);
    }

    //<editor-fold desc="login page element locators">
    By _username = By.id("floatingInput");
    By _password = By.id("floatingPassword");
    By _loginButton = By.xpath("//*[@id=\"login-button\"]");
    By _acceptCookies = By.xpath("//button[normalize-space()='I understand']");


    //</editor-fold>

    //<editor-fold desc="login page methods">
    public void navigateToApp(String appUrl) {
        driver.get(appUrl);
        log.info(appUrl + " launched successfully.");
    }
    public void enterUsernamePassword(String username, String password) {
        clickElementAndEnterText(_username, decryptBase64(username));
        clickElementAndEnterText(_password, decryptBase64(password));
    }
    public void clickApplicationLoginButton() {
        clickElement(_loginButton);
    }
    public void acceptCookies() {

        clickElement(_acceptCookies);
        sleep(10000);
    }

    //</editor-fold>

    /**
     * This is a generic method used for login into the application.
     * This method takes application url, username and password as a parameter.
     */
    public void loginToApp(String url, String username, String password) {
        navigateToApp(url);
        enterUsernamePassword(username, password);
        clickApplicationLoginButton();
    }
}
