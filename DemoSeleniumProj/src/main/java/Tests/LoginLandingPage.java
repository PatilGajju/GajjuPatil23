package Tests;

import AbstractComponent.AbstractComp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLandingPage extends AbstractComp {

    WebDriver driver;
    public LoginLandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);  //initialization all the pageFactory elements used bellow with @find
    }

    public void getURL()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

    //Login Activity WebElements
    @FindBy( id = "userEmail")
            WebElement userEmail;

    @FindBy( id = "userPassword")
            WebElement userPassword;

    @FindBy( id = "login")
            WebElement loginButton;

    //Login Activity using username and password
    public ProductCatelogue loginActivity(String username, String password)
    {
        userEmail.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
        ProductCatelogue productCatelogue;
        productCatelogue = new ProductCatelogue(driver);
        return productCatelogue;
    }




}
