package pageobjects;

import core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PIMPage extends BasePage {
    public PIMPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement employeeId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement submitSearch;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div")
    WebElement employmentStatus;

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

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement buttonAdd;

    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")
    WebElement buttonUpdate;

    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement buttonConfirmDelete;

    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[1]")
    WebElement buttonDelete;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    WebElement inputId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement buttonSave;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6")
    WebElement updateTitle;

    By records_by = By.cssSelector(".oxd-table-card");

    public void search(String id){
        employeeId.sendKeys(id);
        submitSearch.click();
    }

    public void searchByEmpStatus() {
        employmentStatus.click();
        optionsEmpStatus.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[4]")).click();
        submitSearch.click();
    }

    public void searchByInclude() {
        include.click();
        optionsInclude.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]")).click();
        submitSearch.click();
    }

    public void searchByJobTitle() {
        jobTitle.click();
        optionsJobTitle.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div[2]/div[2]")).click();
        submitSearch.click();
    }

    public void searchBySubUnit() {
        subUnit.click();
        optionsSubUnit.get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div[2]/div[2]")).click();
        submitSearch.click();
    }

    public List<WebElement> getRecords() {
        waitForElement(records_by);
        return records;
    }

    public boolean getRecord(String id){
        return getRecords().get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText().equals(id);
    }

    public void goToAdd(){
        buttonAdd.click();
    }

    public boolean getRecordByFilter2(){
        return getRecords().size()>0;
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
        buttonSave.click();
    }

    public boolean message(){
        return updateTitle.getText().equals("Personal Details");
    }

    public void goToUpdate() throws InterruptedException {
        Thread.sleep(2000);
        getRecords().get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[2]")).click();
    }

    public void editName(String name) throws InterruptedException {
        Thread.sleep(2000);
        if(System.getProperty("os.name").replaceAll("\\s", "").equals( "MacOSX")){
            firstName.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        }else{
            firstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        }
        firstName.sendKeys(name);
        buttonUpdate.click();
    }

     public boolean getMessage(String id, String name) {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        search(id);
        return getRecords().get(0).findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div")).getText().equals(name);
    }

    public void deleteEmployee() throws InterruptedException {
        buttonDelete.click();
        Thread.sleep(2000);
        buttonConfirmDelete.click();
    }

    public boolean checkDelete() throws InterruptedException {
        Thread.sleep(2000);
        return records.isEmpty();
    }


}
