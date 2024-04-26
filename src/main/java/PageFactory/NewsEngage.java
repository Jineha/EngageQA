package PageFactory;
import Base.BasePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsEngage extends BasePageObjects {
    public NewsEngage(WebDriver driver) {
        super(driver);
    }

    By _newstab = By.xpath("//*[@id=\"sidebarMenu\"]/div/div[1]/div/ul/li[2]/a");
    By _electric_car = By.cssSelector("img[alt='Electric Car Charging']");
    By _com_volunteering = By.cssSelector("img[alt='Community Volunteering']");
    By _running_club = By.cssSelector("//img[@alt='Running Club']");
    By _backtonews = By.xpath("(//a[@class='btn btn-outline-primary mt-1 mt-lg-2'])[1]");

    public void navigateToNews() { clickElement(_newstab);}

    public void clickelectric_car() { clickElement(_electric_car); }
    public void com_volunteering(){clickElement(_com_volunteering);}
    public void running_club(){clickElement(_running_club);}
    public void backetonewstab() { clickElement(_backtonews); }

    public void engageNews()
    {
        navigateToNews();
        backetonewstab();
    }
}
