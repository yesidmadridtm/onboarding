package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginApp extends BasePage {
    public LoginApp(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement email_app;

    @FindBy(name = "password")
    WebElement password_app;

    @FindBy(className = "oxd-button")
    WebElement submit;

    public PIMPage loginPMI(String email, String password){
        email_app.sendKeys(email);
        password_app.sendKeys(password);
        submit.click();
        return new PIMPage(driver);
    }

    public SideBarPage loginSideBar(String email, String password){
        email_app.sendKeys(email);
        password_app.sendKeys(password);
        submit.click();
        return new SideBarPage(driver);
    }
}
