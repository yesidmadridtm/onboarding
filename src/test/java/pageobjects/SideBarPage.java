package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBarPage extends BasePage {

    public SideBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement inputSearch;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span")
    WebElement resultSearch;

    public void search(String menu) {
        inputSearch.sendKeys(menu);
    }

    public boolean checkResult(String menu) {
        return resultSearch.getText().equals(menu);
    }


}
