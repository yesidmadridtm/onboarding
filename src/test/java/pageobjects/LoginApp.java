package pageobjects;

import core.BasePage;
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
        PIMPage page = new PIMPage(driver);
        return page;
    }

    public SideBarPage loginSideBar(String email, String password){
        email_app.sendKeys(email);
        password_app.sendKeys(password);
        submit.click();
        SideBarPage page = new SideBarPage(driver);
        return page;
    }
}
