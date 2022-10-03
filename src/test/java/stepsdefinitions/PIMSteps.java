package stepsdefinitions;

import base.BaseTest;
import data.User;
import data.UserBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginApp;

public class PIMSteps extends BaseTest {
    public pageobjects.PIMPage page;
    public LoginApp login;
    public String idEmployee = "0024";

    public String idNewEmployee = "1111";

    private void login(){
        User user = UserBuilder.getUser();
        login = new LoginApp(driver);
        page = login.loginPMI(user.getUsername(), user.getPassword());
    }


    @Given("Client see the records of employees, He want filter these records by Id")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsById() {
        login();
    }

    @When("He search an Id")
    public void heSearchAnId() throws InterruptedException {
        page.search(idEmployee);
    }

    @Then("data has been filtered with this Id")
    public void dataHasBeenFilteredWithThisId() {
        Assert.assertTrue(page.getRecord(idEmployee));
    }

    @Given("Client see the records of employees, He want filter these records by Employment Status")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsByEmploymentStatus() {
        login();
    }

    @When("He search an employee using an Employment Status")
    public void heSearchAnEmployeeUsingAnEmploymentStatus() {
        page.searchByEmpStatus();
    }

    @Then("data has been filtered with this Employment Status")
    public void dataHasBeenFilteredWithEmploymentStatus() throws InterruptedException {
        Assert.assertTrue(page.getRecordByFilter2());
    }

    @Given("Client see the records of employees, He want filter these records by Include")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsByInclude() {
        login();
    }

    @When("He search an employee using an Include")
    public void heSearchAnEmployeeUsingAnInclude() {
        page.searchByInclude();
    }

    @Then("data has been filtered with this Include")
    public void dataHasBeenFilteredWithThisInclude() throws InterruptedException {
        Assert.assertTrue(page.getRecordByFilter2());
    }

    @Given("Client see the records of employees, He want filter these records by Job Title")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsByJobTitle() {
        login();
    }

    @When("He search an employee using an Job Title")
    public void heSearchAnEmployeeUsingAnJobTitle() {
        page.searchByJobTitle();
    }

    @Then("data has been filtered with this Job Title")
    public void dataHasBeenFilteredWithThisJobTitle() throws InterruptedException {
        Assert.assertTrue(page.getRecordByFilter2());
    }

    @Given("Client see the records of employees, He want filter these records by Sub Unit")
    public void clientSeeTheRecordsOfEmployeesHeWantFilterTheseRecordsBySubUnit() {
        login();
    }

    @When("He search an employee using an Sub Unit")
    public void heSearchAnEmployeeUsingAnSubUnit() {
        page.searchBySubUnit();
    }

    @Then("data has been filtered with this Sub Unit")
    public void dataHasBeenFilteredWithThisSubUnit() throws InterruptedException {
        Assert.assertTrue(page.getRecordByFilter2());
    }

    @Given("Client want to add an new employee in the application")
    public void clientWantAddAnNewEmployeeInTheApplication() {
        login();
    }

    @When("He go to registration form")
    public void heGoToRegistrationForm() {
        page.goToAdd();
    }

    @And("He provides information about new employee")
    public void heProvidesInformationAboutNewEmployee() throws InterruptedException {
        page.addValuesAdd(idNewEmployee, "pepito", "perez");
    }

    @Then("the information is registered")
    public void theInformationIsRegistered() {
        Assert.assertTrue(page.message());
    }


    @Given("Client want to edit name of an employee in the application")
    public void clientWantToEditNameOfAnEmployeeInTheApplication() {
        login();
    }

    @When("He search an employee using his Id")
    public void heSearchAnEmployeeUsingHisId() {
        page.search(idNewEmployee);
    }

    @And("He go to form of update")
    public void heGoToFormOfUpdate() {
        page.goToUpdate();
    }

    @And("He provides new name of employee")
    public void heProvidesNewNameOfEmployee() throws InterruptedException {
        page.editName("juan");
    }

    @Then("the name is updated")
    public void theNameIsUpdated() throws InterruptedException {
        Assert.assertTrue(page.getMessage(idNewEmployee, "juan"));
    }

    @Given("Client want to delete an employee in the application")
    public void clientWantToDeleteAnEmployeeInTheApplication() {
        login();
    }

    @When("He search an employee in list using his Id")
    public void heSearchAnEmployeeInListUsingHisId() {
        page.search(idNewEmployee);
    }

    @And("He go to action of delete")
    public void heGoToActionOfDelete() {
        page.deleteEmployee();
    }

    @Then("the employee has been deleted")
    public void theEmployeeHasBeenDeleted() {
        Assert.assertTrue(page.checkDelete());
    }

}

