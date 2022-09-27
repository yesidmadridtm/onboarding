package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginApp;

import java.time.Duration;


public class test {
    public static void main(String args[]){

        /*System.setProperty("webdriver.chrome.driver", "/Users/wtredatateam/IdeaProjects/onboardingTechMahindra/src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());

        driver.manage().timeouts().implicitlyWait(duration***);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("oxd-button")).click();

        System.out.println(driver.getTitle());

        driver.close();
        driver.quit();*/
        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // consumo de clase Login
        LoginApp login = new LoginApp(driver);
        login.goToLogin();
        login.login("Admin", "admin123");
        login.close();*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // consumo de clase Login
        LoginApp login = new LoginApp(driver);
        login.goToLogin();
        login.login("Admin", "admin123");

        login.close();



        //// clase hooks, ingresar las 3 lineas, utilizar las anotaciones de cucumber
    }
}
