package PageFactory;

import Base.BasePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardHomePage extends BasePageObjects {

    public DashboardHomePage(WebDriver driver) {
        super(driver);
    }

    //<editor-fold desc="Application homepage element locators">
    By _subscriptionStatus = By.id("subscribe_status_popup");
    By _closeSubscriptionPopup = By.xpath("//span[@class='popup-close']");
    By _expandUserProfile = By.id("account");
    By _logout = By.xpath("//a[normalize-space()='Logout']");
    By _logoutText = By.xpath("//span[normalize-space()='Logged Out Successfully']");

    //</editor-fold>

    //<editor-fold desc="Application homepage methods">
    public boolean isSubscriptionMessageDisplay() {
        return isElementDisplayed(_subscriptionStatus);
    }

    public void closeSubscriptionPopup() {
        clickElement(_closeSubscriptionPopup);
    }

    public String expandUserProfileAndLogout() {
        clickElement(_expandUserProfile);
        clickElement(_logout);
        return getElementText(_logoutText);
    }

    //</editor-fold>
}
