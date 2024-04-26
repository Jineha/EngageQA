package StepDefinitions;

import PageFactory.Login;
import PageFactory.ClientPage;
import PageFactory.DashboardHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static Base.TestBase.driver;
import static Base.TestBase.getProperty;

public class ClientSteps {

    Login login = new Login(driver);
    ClientPage cp = new ClientPage(driver);
    DashboardHomePage hp = new DashboardHomePage(driver);

    @Given("User login into the application")
    public void userLoginIntoTheApplication() throws InterruptedException {
        login.loginToApp(getProperty("ApplicationUrl"), getProperty("AgentUserName"), getProperty("AgentPassword"));
        //Assert.assertEquals("MY DASHBOARD", login.GetLandingPageText());
        if (hp.isSubscriptionMessageDisplay()) {
            hp.closeSubscriptionPopup();
        }
    }

    @And("click on create new client button")
    public void clickOnCreateNewClientButton() {
        cp.clickCreateNewClientButton();
    }

    @When("User Enter client data and click create button")
    public void userEnterClientDataAndClickCreateButton() {
    }

    @Then("New client should be created into the application")
    public void newClientShouldBeCreatedIntoTheApplication() {

    }

    @And("client should be display on the application dashboard")
    public void clientShouldBeDisplayOnTheApplicationDashboard() {
    }


}
