package StepDefinitions;

import Base.TestBase;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestBase {

    @BeforeAll(order = 0)
    public static void beforeAll() {
        readPropertiesFileAndSetup();
        openBrowser();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
        driver = null;
    }

    @Before
    public static void beforeScenario(Scenario scenario) {
        log.info("Scenario execution started. " + scenario.getName());
    }

    @After
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
            log.error(scenario.isFailed());
        }
    }
}
