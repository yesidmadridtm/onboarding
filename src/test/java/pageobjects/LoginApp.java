package pageobjects;

import core.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginApp extends AbstractComponent {
    public LoginApp(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "username")
    WebElement email_app;

    @FindBy(name = "password")
    WebElement password_app;

    @FindBy(className = "oxd-button")
    WebElement submit;

    public PIMPage login(String email, String password){
        email_app.sendKeys(email);
        password_app.sendKeys(password);
        submit.click();
        PIMPage page = new PIMPage(driver);
        return page;
    }
}
