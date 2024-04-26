package StepDefinitions;

import PageFactory.Login;
import PageFactory.NewsEngage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static Base.TestBase.driver;
import static Base.TestBase.getProperty;
import static java.lang.Thread.sleep;

public class NewsEngageSteps {
    Login login = new Login(driver);
    NewsEngage news = new NewsEngage(driver);

    @When("User successfully logged into the browser")
    public void userSuccessfullyLoggedIntoTheBrowser()
    {
        login.loginToApp(getProperty("ApplicationUrl"),getProperty("UserName"),getProperty("Password"));
        news.sleep(2000);
    }

    @Given("Once the cookies accepted")
    public void onceTheCookiesAccepted()
    {
        login.acceptCookies();
        news.sleep(2000);
    }

    @When("User click on particular news tab")
    public void userClickNSwsTab() {

        news.navigateToNews();

        news.clickelectric_car();
        news.sleep(2000);
        news.backetonewstab();

        news.sleep(2000);

        news.com_volunteering();
        news.sleep(3000);
        news.backetonewstab();

        news.sleep(2000);

        news.running_club();
        news.sleep(5000);
        news.backetonewstab();
    }

    @Then("User should be redirect to news tab successfully")
    public void userShouldBeRedirectToNewsTabSuccessfully()
    {
        news.backetonewstab();
    }

}
