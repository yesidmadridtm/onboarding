package pageobjects;

import core.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class PIMPage extends AbstractComponent {
    public PIMPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement employee_id;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement submit_search;

    @FindBy(css = ".oxd-table-body")
    List<WebElement> records;

    By records_by = By.cssSelector(".oxd-table-body");

    public void search(String id){
        employee_id.sendKeys(id);
        submit_search.click();
    }

    public List<WebElement> getRecords() {
        waitForElement(records_by);
        return records;
    }

    public boolean getRecord(String id){
        return getRecords().get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText().equals(id);
    }
}
