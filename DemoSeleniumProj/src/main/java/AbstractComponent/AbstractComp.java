package AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComp {

    static WebDriver driver;
    public AbstractComp(WebDriver driver) {
        AbstractComp.driver =driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[routerLink*='cart']")
    WebElement cart;

    @FindBy(xpath = "//li[@class='totalRow']/button[@class='btn btn-primary']")
    WebElement checkoutButton;


    public static void appearWait(By visibleElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.valueOf(visibleElement))));
    }

    public static void waitToDisapper(WebElement invisibleElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(String.valueOf(invisibleElement)));
    }

    public void goToCart()
    {
        cart.click();
    }

    public checkOutPage goTocheckOutButton()
    {
        checkoutButton.click();
        checkOutPage CheckOutPage;
        CheckOutPage = new checkOutPage(driver);
        return CheckOutPage;
    }



}
