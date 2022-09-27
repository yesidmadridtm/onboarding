package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginApp;

import java.time.Duration;

public class Hooks extends BaseTest{

    //@BeforeMethod(alwaysRun = true)
    @Before()
    public LoginApp runApp(){
        driver = initDriver();
        login = new LoginApp(driver);
        login.goToLogin();

        return login;
    }

    //@AfterMethod(alwaysRun = true)
    @After()
    public void downApp(){
        driver.close();
    }
}
