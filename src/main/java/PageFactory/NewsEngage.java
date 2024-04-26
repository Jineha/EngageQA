package PageFactory;
import Base.BasePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NewsEngage extends BasePageObjects {
    public NewsEngage(WebDriver driver) {
        super(driver);
    }

    By _newstab = By.xpath("//*[@id=\"sidebarMenu\"]/div/div[1]/div/ul/li[2]/a");
    By _electric_car = By.cssSelector("img[alt='Electric Car Charging']");
    By _com_volunteering = By.cssSelector("img[alt='Community Volunteering']");
    By _running_club = By.xpath("//img[@alt='Running Club']");
    By _coffee_morning = By.xpath("//img[@alt='Coffee Morning']");
    By _gym_equipment = By.xpath("//img[@alt='Gym Equipment']");
    By _parking_permits = By.xpath("//img[@alt='Parking Permits']");
    By _backtonews = By.xpath("//a[contains(text(),'Back to')]");

    public void navigateToNews() { clickElement(_newstab);}

    public void clickelectric_car() { clickElement(_electric_car); }
    public void com_volunteering(){clickElement(_com_volunteering);}
    public void running_club(){clickElement(_running_club);}
    public void coffee_morning(){clickElement(_coffee_morning);}
    public void gym_equipment(){clickElement(_gym_equipment);}
    public void parking_permits(){clickElement(_parking_permits);}
    public void backetonewstab(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        clickElement(_backtonews); }

    public void engageNews()
    {
        navigateToNews();
        backetonewstab();
    }
}
