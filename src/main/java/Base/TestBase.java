package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class TestBase {
    public static final Logger log = LogManager.getLogger(TestBase.class.getName());


    public static WebDriver driver = null;
    private static Properties prop = null;
    private static final int implicitWait = 10;


    /**
     * This is a common method for setting up a project environment.
     * This method is used to read environment-specific properties files
     * and get data from the file.
     */
    protected static void readPropertiesFileAndSetup() {
        try {
            FileInputStream fileInput;
            prop = new Properties();
            fileInput = new FileInputStream(".\\src\\test\\Resources\\Properties\\"
                    + setEnvironment() + "_env.properties");
            prop.load(fileInput);
            log.info(setEnvironment() + " Environment property file setup successfully");
            fileInput.close();
        } catch (Exception e) {
            log.error("error occurred while reading properties file." + e);
            throw new RuntimeException(e);

        }
    }

    private static String setEnvironment() {
        String environment = System.getProperty("test.env");
        if (environment == null || environment.isEmpty()) {
            environment = "dev";
        }
        return environment.toLowerCase();
    }

    private static String setBrowser() {
        String browserType = System.getProperty("browser.type");
        if (browserType == null || browserType.isEmpty()) {
            browserType = getProperty("BrowserType");
        }
        return browserType.toLowerCase();
    }

    /**
     * This method is used to set up a browser.
     * It takes browser values from the property file.
     * The default value of the web browser is set to Chrome.
     * The user needs to provide a browser type,
     * and based on user input, the scripts will start execution.
     */
    public static void openBrowser() {
        log.info("-------- Automation framework triggered. --------" +
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " --------");
        switch (setBrowser()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.info("Application launched in a chrome browser.");
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("Application launched in a firefox browser.");
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                log.info("Application launched in a edge browser.");
                break;
            case "headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                log.info("Application launched in a headless chrome browser.");
                break;
            default:
                log.error("Browser type is not available.");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    public static String getProperty(String propValue) {
        return prop.getProperty(propValue);
    }


//this is test commit update
}
