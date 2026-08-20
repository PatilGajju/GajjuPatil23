package Tests.BaseTest;

import Tests.LoginLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class initializeComp {

    public WebDriver driver ;
    public LoginLandingPage loginLandingPage;
    public WebDriver initializeChrome() throws IOException
    {

        Properties prop = new Properties();
        FileInputStream filename = new FileInputStream("/Users/gajendrasingh/IdeaProjects/MavenSeleniium/src/test/java/Tests/resources/GlobalData.properties");
        prop.load(filename);
        String browserName = prop.getProperty("browser");
        System.out.println("browserName :"+browserName);

        if(browserName.equalsIgnoreCase("chrome")) {
             driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }

    @BeforeMethod
    public void launchApplication() throws IOException
    {
        System.out.println("Set2");
        driver=initializeChrome();
    }

    public LoginLandingPage getLoginLandingPage()
    {
        LoginLandingPage loginLandingPage = new LoginLandingPage(driver);
        System.out.println("Set3");
        loginLandingPage.getURL();
        return loginLandingPage;
    }

    @AfterMethod
    public void closeBrower()
    {
        driver.close();
    }


}
