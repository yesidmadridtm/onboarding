package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.LoginApp;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public LoginApp login;

    public WebDriver initDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LoginApp runApp(){
        driver = initDriver();
        login = new LoginApp(driver);
        login.goToLogin();

        return login;
    }

    @AfterMethod(alwaysRun = true)
    public void downApp(){
        driver.close();
    }
}
