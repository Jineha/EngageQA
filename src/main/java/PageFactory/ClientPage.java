package PageFactory;

import Base.BasePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientPage extends BasePageObjects {

    //<editor-fold desc="client page element locators">
    By _createNewClient = By.xpath("//button[@class='button orange cdash-cr-clnt']");
    By _firstName = By.xpath("//input[@placeholder='First Name']");
    By _middleName = By.xpath("//input[@placeholder='Middle Name']");
    By _lastName = By.xpath("//input[@placeholder='Last Name']");
    By _companyName = By.xpath("//input[@placeholder='Company Name']");
    By _email = By.xpath("//input[@name='email']");
    By _alternateEmail = By.xpath("//input[@name='alternate_email']");
    By _phone = By.id("phone");
    By _phoneExt = By.xpath("//input[@name='phone_ext']");
    By _alternatePhone= By.id("phone1");
    By _alternatePhoneExt = By.xpath("//input[@name='phone1_ext']");
    By _streetNumber = By.id("street_number");
    By _streetDirection = By.xpath("//select[@name='street_direction']");
    By _streetName = By.id("street_name");
    By _unit = By.id("mnunit");
    By _city = By.name("city");
    By _state = By.name("state");
    By _pinCode = By.name("pincode");
    By _country = By.name("country");
    By _createButton = By.id("c_btn");

    //</editor-fold>

    //<editor-fold desc="client page methods">
    public ClientPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewClientButton() {
        clickElement(_createNewClient);
    }
    public void clickCreateClientButton() {
        clickElement(_createButton);
    }

    //</editor-fold>
}
