package AbstractComponent;

import Tests.ConfirmationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutPage extends AbstractComp{

    WebDriver driver;

    public checkOutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(css = "[placeholder='Select Country']")
           WebElement selectCountry;
   @FindBy(xpath ="//*[@class='btnn action__submit ng-star-inserted']")
           WebElement actionSubmit;
   @FindBy(xpath ="//*[text()=' India']")
           WebElement selectIndia;
   By result = By.xpath("//*[@class='ta-results list-group ng-star-inserted']");


    public void selectCountry(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(selectCountry,countryName).build().perform();

        appearWait(By.id(String.valueOf(result)));
        selectIndia.click();
    }

    public ConfirmationPage submitOrder()
    {
        actionSubmit.click();
        ConfirmationPage confirmationPage;
        confirmationPage = new ConfirmationPage(driver);
        return confirmationPage;
    }

}
