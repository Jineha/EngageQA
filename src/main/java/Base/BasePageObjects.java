package Base;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Base.TestBase.driver;

public class BasePageObjects {
    protected static final Logger log = LogManager.getLogger(BasePageObjects.class.getName());
    protected WebDriver driver;
    private int explicitWait = 10;

    public BasePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyElementPresent(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(explicitWait)).
                until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean isElementDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public void clickElement(By element) {
        verifyElementPresent(element);
        driver.findElement(element).click();
    }
    public void clickElementAndEnterText(By element, String text) {
        clickElement(element);
        if (!text.isEmpty()) {
            driver.findElement(element).clear();
        }
        driver.findElement(element).sendKeys(text);
    }
    public String getElementText(By element) {
        verifyElementPresent(element);
        return driver.findElement(element).getText().trim();
    }
    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String decryptBase64(String decodeString) {
        byte[] valueDecoded = Base64.decodeBase64(decodeString);
        return new String(valueDecoded);
    }
    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }
    public void switchBetweenTabsAndClose(int tabId)
    {
        ArrayList<String>tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabId));
        driver.close();
    }
}
