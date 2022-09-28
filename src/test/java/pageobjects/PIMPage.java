package pageobjects;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PIMPage extends BasePage {
    public PIMPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement employee_id;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement submit_search;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div")
    WebElement employment_status;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")
    WebElement include;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div")
    WebElement jobTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div")
    WebElement subUnit;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]")
    List<WebElement> optionsEmpStatus;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]")
    List<WebElement> optionsInclude;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div[2]")
    List<WebElement> optionsJobTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div[2]")
    List<WebElement> optionsSubUnit;

    @FindBy(css = ".oxd-table-card")
    List<WebElement> records;

    By records_by = By.cssSelector(".oxd-table-card");

    public void search(String id){
        employee_id.sendKeys(id);
        submit_search.click();
    }

    public void searchByEmpStatus() {
        employment_status.click();
        optionsEmpStatus.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[4]")).click();
        submit_search.click();
    }

    public void searchByInclude() {
        include.click();
        optionsInclude.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]")).click();
        submit_search.click();
    }

    public void searchByJobTitle() {
        jobTitle.click();
        optionsJobTitle.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div[2]/div[2]")).click();
        submit_search.click();
    }

    public void searchBySubUnit() {
        subUnit.click();
        optionsSubUnit.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div[2]/div[2]")).click();
        submit_search.click();
    }

    public List<WebElement> getRecords() {
        waitForElement(records_by);
        return records;
    }

    public boolean getRecord(String id){
        return getRecords().get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText().equals(id);
    }

    public boolean getRecordByFilter2(){
        return getRecords().size()>0;
    }
}
