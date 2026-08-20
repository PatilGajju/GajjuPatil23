package Tests;

import AbstractComponent.AbstractComp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductCatelogue extends AbstractComp {

    WebDriver driver;
    public ProductCatelogue(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By elementproduct = By.cssSelector(".mb-3");
    By addToCart      = By.xpath(".//*[text()=' Add To Cart']");
    By toastmsg       = By.xpath("//div[@id='toast-container']");
    By spinner        = By.cssSelector(".ng.animating");

    public List<WebElement> getProductList()
    {
        appearWait(elementproduct);
        return products;
    }
    //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

   public WebElement getProductByName(String productName)
   {
       WebElement prod;
       prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
       return prod;
   }

   public void ClickAddToCart(String productName)
   {
       WebElement prod = getProductByName(productName);
       prod.findElement(addToCart).click();
       appearWait(toastmsg);
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }
}
