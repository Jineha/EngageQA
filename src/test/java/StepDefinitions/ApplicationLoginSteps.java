package StepDefinitions;

import PageFactory.DashboardHomePage;
import PageFactory.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;


import static Base.TestBase.*;

public class ApplicationLoginSteps {

    Login login = new Login(driver);
    DashboardHomePage homepage = new DashboardHomePage(driver);
    private String _pageURL;

    @When("User opens the application in a web browser")
    public void userOpensTheApplicationInAWebBrowser() {
        login.navigateToApp(getProperty("ApplicationUrl"));
    }

    @Given("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        login.enterUsernamePassword((getProperty("AgentUserName")), getProperty("AgentPassword"));
    }

    @When("User click login button")
    public void user_click_login_button() {
        login.clickApplicationLoginButton();
    }

    @Then("User should be redirect to the Application dashboard homepage")
    public void user_should_be_redirect_to_the_application_dashboard_homepage() {
        Assert.assertEquals("MY DASHBOARD", login.GetLandingPageText());
    }

    @And("Logout From the Application")
    public void logoutFromTheApplication() {
        if (homepage.isSubscriptionMessageDisplay()) {
            homepage.closeSubscriptionPopup();
        }
        Assert.assertEquals("Logged Out Successfully", homepage.expandUserProfileAndLogout());
    }

    @Given("User enters a combination of a valid invalid agent {string} and {string}")
    public void userEntersACombinationOfAValidInvalid(String username, String password) {
        login.enterUsernamePassword(username, password);
    }

    @Then("User should have gotten a validation {string} and not been able to login.")
    public void userShouldHaveGottenAValidationAndNotBeenAbleToLogin(String message) {
        Assert.assertEquals(message, login.getInvalidLoginInfoText());
    }

    @Given("User login into the application and landing on the dashboard")
    public void user_login_into_the_application_and_landing_on_the_dashboard() {
        login.loginToApp(getProperty("ApplicationUrl"), getProperty("AgentUserName"), getProperty("AgentPassword"));
        Assert.assertEquals("MY DASHBOARD", login.GetLandingPageText());
    }
    @When("User gets the current page URL and open a new tab")
    public void user_gets_the_current_page_url_and_open_a_new_tab() {
        _pageURL = driver.getCurrentUrl();
        login.openNewTab();
    }

    @When("User open a new tab and hit the page URL")
    public void user_open_a_new_tab_and_hit_the_page_url() {
        driver.get(_pageURL);
    }
    @Then("User should be redirect to the application loginPage")
    public void user_should_be_redirect_to_the_application_login_page() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(login.landingPageHeaderDisplay()).isTrue();
    }

    @When("user close the browser and open new browser")
    public void userCloseTheBrowserAndOpenNewBrowser() {
        openBrowser();
    }

    @And("hit the page URL")
    public void hitThePageURL() {
        driver.get(_pageURL);
    }
}
