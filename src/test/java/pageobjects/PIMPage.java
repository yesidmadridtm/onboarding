package pageobjects;

import core.BasePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PIMPage extends BasePage {
    public PIMPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@class, 'oxd-input oxd-input--active')]")
    List<WebElement> employeeId;

    @FindBy(xpath = "//button[contains(@class,'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]")
    WebElement submitSearch;

    @FindBy(xpath = "//div[contains(@class, 'oxd-select-text oxd-select-text--active')]")
    List<WebElement> filterEmployee;

    By locator = By.xpath("//div[contains(@class,'oxd-select-dropdown --positon-bottom')]");
    WebElement opt;

    @FindBy(css = ".oxd-table-card")
    List<WebElement> records;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement buttonAdd;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]")
    List<WebElement> buttonUpdate;

    @FindBy(xpath = "//i[contains(@class, 'oxd-icon bi-trash oxd-button-icon')]")
    WebElement buttonConfirmDelete;

    @FindBy(xpath = "//i[contains(@class, 'oxd-icon bi-trash')]")
    WebElement buttonDelete;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    WebElement inputId;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]")
    List<WebElement> buttonSave;

    @FindBy(xpath = "//h6[contains(@class, 'oxd-text oxd-text--h6 orangehrm-main-title')]")
    List<WebElement> updateTitle;

    @FindBy(className = "oxd-loading-spinner")
    WebElement loadingSpinner;

    public void search(String id) {
        employeeId.get(1).sendKeys(id);
        submitSearch.click();
    }

    public void searchByEmpStatus() {
        filterEmployee.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        opt = driver.findElement(locator);
        opt.findElement(By.xpath("//span[text()='Full-Time Contract']")).click();
        submitSearch.click();
    }

    public void searchByInclude() {
        filterEmployee.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        opt = driver.findElement(locator);
        opt.findElement(By.xpath("//span[text()='Current and Past Employees']")).click();
        submitSearch.click();
    }

    public void searchByJobTitle() {
        filterEmployee.get(2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        opt = driver.findElement(locator);
        opt.findElement(By.xpath("//span[text()='Content Specialist']")).click();
        submitSearch.click();
    }

    public void searchBySubUnit() {
        filterEmployee.get(3).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        opt = driver.findElement(locator);
        opt.findElement(By.xpath("//span[text()='Administration']")).click();
        submitSearch.click();
    }

    public boolean getRecord(String id){
        return records.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText().equals(id);
    }

    public void goToAdd(){
        buttonAdd.click();
    }

    public boolean getRecordByFilter2() throws InterruptedException {
        Thread.sleep(5000);
        return records.size()>0;
    }

    public void addValuesAdd(String id, String name, String last) {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        inputId.click();
        if(System.getProperty("os.name").replaceAll("\\s", "").equals( "MacOSX")){
            inputId.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        }else{
            inputId.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        }
        inputId.sendKeys(id);
        buttonSave.get(0).click();
    }

    public boolean message() {
        return updateTitle.get(0).getText().equals("Personal Details");
    }

    public void goToUpdate() {
        wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
        records.get(0).findElement(By.xpath("//i[contains(@class, 'oxd-icon bi-pencil-fill')]")).click();
    }

    public void editName(String name) throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
        if(System.getProperty("os.name").replaceAll("\\s", "").equals( "MacOSX")){
            firstName.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        }else{
            firstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        }
        firstName.sendKeys(name);
        buttonUpdate.get(0).click();
    }

     public boolean getMessage(String id, String name) throws InterruptedException {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        search(id);
        wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
        return records.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div")).getText().equals(name);
    }

    public void deleteEmployee() {
        buttonDelete.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet " +
                        "oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']")));
        buttonConfirmDelete.click();
    }

    public boolean checkDelete() {
        wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
        return records.isEmpty();
    }
}