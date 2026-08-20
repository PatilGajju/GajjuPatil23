import AbstractComponent.checkOutPage;
import Tests.BaseTest.initializeComp;
import Tests.ConfirmationPage;
import Tests.LoginLandingPage;
import Tests.ProductCatelogue;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends initializeComp {

        @Test
        public  void SubmitOrder() throws IOException {
            String productName = "ZARA COAT 3";
            System.out.println("Set1");
            LoginLandingPage landingPage = getLoginLandingPage();
            System.out.println("Set4");
            ProductCatelogue productCatelogue = landingPage.loginActivity("priyanka@example.com", "Priyanka23@@");
            System.out.println("Set5");
            //AbstractComp.appearWait(".mb-3");
            productCatelogue.getProductByName(productName);
            productCatelogue.ClickAddToCart(productName);
            productCatelogue.goToCart();
            checkOutPage CheckOutPage = productCatelogue.goTocheckOutButton();
            CheckOutPage.selectCountry("India");
            ConfirmationPage confirmationPage = CheckOutPage.submitOrder();
            String condirmationMessage = confirmationPage.confirmMsgText();
            System.out.println("condirmationMessage: "+condirmationMessage);
            Assert.assertTrue(condirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


            //WebDriver.ChromeDriver.setup();
            //WebDriver driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //driver.manage().window().maximize();
            //driver.get("https://rahulshettyacademy.com/client");

            //LoginLandingPage
            //driver.findElement(By.id("userEmail")).sendKeys("priyanka@example.com");
            //driver.findElement(By.id("userPassword")).sendKeys("Priyanka23@@");
            //driver.findElement(By.id("login")).click();

            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3"));
            //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));


            //WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);


            //prod.findElement(By.xpath(".//*[text()=' Add To Cart']")).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng.animating")));


            //driver.findElement(By.xpath("//button[@routerLink='/dashboard/cart']")).click();


            //driver.findElement(By.xpath("//li[@class='totalRow']/button[@class='btn btn-primary']")).click();


            //Actions a = new Actions(driver);
            //a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ta-results list-group ng-star-inserted']")));
            //river.findElement(By.xpath("//*[text()=' India']")).click();


            //driver.findElement(By.xpath("//*[@class='btnn action__submit ng-star-inserted']")).click();
            //String condirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();









        }
}
