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

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]")
    List<WebElement> options;

    @FindBy(css = ".oxd-table-card")
    List<WebElement> records;

    By records_by = By.cssSelector(".oxd-table-card");

    public void search(String id){
        employee_id.sendKeys(id);
        submit_search.click();
    }

    public void searchByEmpStatus() {
        employment_status.click();
        options.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[4]")).click();
        submit_search.click();
    }

    public List<WebElement> getRecords() {
        waitForElement(records_by);
        return records;
    }

    public boolean getRecord(String id){
        System.out.println(getRecords().get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText());
        return getRecords().get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText().equals(id);
    }

    public boolean getRecordByFilter2(){
        return getRecords().size()>0;
    }
}

/*

<div role="listbox" class="oxd-select-dropdown --positon-bottom" loading="false" data-v-768a7d72="" data-v-15ec1d6f="">
<div role="option" class="oxd-select-option" data-v-a96a71ca="" data-v-15ec1d6f="">-- Select --</div>
<div role="option" class="oxd-select-option" data-v-a96a71ca="" data-v-15ec1d6f="">
    <span data-v-15ec1d6f="">Freelance</span></div>
<div role="option" class="oxd-select-option" data-v-a96a71ca="" data-v-15ec1d6f="">
    <span data-v-15ec1d6f="">Full-Time Contract</span></div>
<div role="option" class="oxd-select-option" data-v-a96a71ca="" data-v-15ec1d6f="">
    <span data-v-15ec1d6f="">Full-Time Permanent</span></div>
<div role="option" class="oxd-select-option" data-v-a96a71ca="" data-v-15ec1d6f=""><span data-v-15ec1d6f="">Full-Time Probation</span></div><div role="option" class="oxd-select-option" data-v-a96a71ca="" data-v-15ec1d6f=""><span data-v-15ec1d6f="">Part-Time Contract</span></div><div role="option" class="oxd-select-option" data-v-a96a71ca="" data-v-15ec1d6f=""><span data-v-15ec1d6f="">Part-Time Internship</span></div></div>
*/
